package com.my.flowersharm.controller;

import com.my.flowersharm.controller.parsers.NameParser;
import com.my.flowersharm.model.domain.*;
import com.my.flowersharm.service.FlowerService;
import com.my.flowersharm.service.TreeService;
import com.my.flowersharm.service.impl.FlowerServiceImpl;
import com.my.flowersharm.service.impl.TreeServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.HashMap;
import java.util.Map;

public class CreateTreeCommand implements Command {
    private TreeService treeService = TreeServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        String name = model.findParameter("name", new NameParser(errors));
        Size size = Size.valueOf(model.findParameter("size").toUpperCase());

        if (errors.isEmpty()) {
            treeService.createTree(new Tree(name, size));
            return "redirect:/app/tree/list";
        }
        model.setAttributes(errors);
        model.setAttribute("sizes", Size.values());
        return "/views/tree_create.jsp";
    }

}
