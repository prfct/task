package com.my.flowersharm.web;


import com.my.flowersharm.controller.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherContext {
    private static DispatcherContext instance = new DispatcherContext();

    private Map<String, Map<HttpMethod, Command>> commands;

    private DispatcherContext() {
        initControllers();
    }

    static DispatcherContext getInstance() {
        return instance;
    }

    private void initControllers() {
        commands = new ContextBuilder()
                .register("/bouquet/list", new ShowBouquetListCommand())
                .register("/bouquet/create", new ShowCreateBouquetPageCommand())
                .register("/bouquet/create", HttpMethod.POST, new CreateBouquetCommand())
                .register("/bouquet/detail", HttpMethod.POST, new DetailBouquetCommand())
                .register("/bouquet/sort_fresh", HttpMethod.POST, new SortFlowerByFresh())
                .register("/bouquet/diapason", HttpMethod.POST, new DiapasonFlowers())
                .register("/flower/create", new ShowCreateFlowerPageCommand())
                .register("/flower/create", HttpMethod.POST, new CreateFlowerCommand())
                .register("/flower/list", new FlowerListCommand())
                .register("/tree/create", new ShowCreateTreePageCommand())
                .register("/tree/create", HttpMethod.POST, new CreateTreeCommand())
                .register("/tree/list", new TreeListCommand())
                .register("/accessories/create", new ShowCreateAccessoriesPageCommand())
                .register("/accessories/create", HttpMethod.POST, new CreateAccessoriesCommand())
                .register("/accessories/list", new AccessoriesListCommand())
                .build();
    }

    void process(HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DispatcherModel model = new DispatcherModel();
        model.setParameters(request.getParameterMap());
        String path = executeBusinessLogic(method, model, request);

        for (Map.Entry<String, Object> attributes : model.getAttributes().entrySet()) {
            request.setAttribute(attributes.getKey(), attributes.getValue());
        }

        if (!redirectIfNecessary(path, response)) {
            request.getRequestDispatcher(path).forward(request, response);
        }
    }

    private boolean redirectIfNecessary(String url, HttpServletResponse response) throws ServletException, IOException {
        if (url.startsWith("redirect:")) {
            response.sendRedirect(url.substring(url.indexOf(":") + 1));
            return true;
        }
        return false;
    }

    private String executeBusinessLogic(HttpMethod method, Model model, HttpServletRequest request) {
        Command command = findCommand(request.getPathInfo(), method);
        if (command != null) {
            try {
                return command.execute(model);
            } catch (Exception e) {
                return "/views/error.jsp";
            }
        } else {
            return "/views/404.jsp";
        }
    }

    private Command findCommand(String path, HttpMethod method) {
        Map<HttpMethod, Command> commandsMap = commands.get(path);
        Command command = null;
        if (commandsMap != null && commandsMap.containsKey(method)) {
            command = commandsMap.get(method);
        }
        return command;
    }

    private class ContextBuilder {
        private Map<String, Map<HttpMethod, Command>> commands = new HashMap<>();

        private ContextBuilder register(String path, Command command) {
            return register(path, HttpMethod.GET, command);
        }

        private ContextBuilder register(String path, HttpMethod method, Command command) {
            Map<HttpMethod, Command> map = findCommandMap(path);
            map.put(method, command);
            return this;
        }

        private Map<HttpMethod, Command> findCommandMap(String path) {
            Map<HttpMethod, Command> map;
            if (commands.containsKey(path)) {
                map = commands.get(path);
            } else {
                map = new HashMap<>();
            }
            commands.put(path, map);
            return map;
        }

        private Map<String, Map<HttpMethod, Command>> build() {
            return commands;
        }
    }


}
