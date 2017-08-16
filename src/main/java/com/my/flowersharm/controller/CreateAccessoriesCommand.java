package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.AccessoriesType;
import com.my.flowersharm.service.AccessoriesService;
import com.my.flowersharm.service.exception.ExistAccessoryException;
import com.my.flowersharm.service.impl.AccessoriesServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.HashMap;
import java.util.Map;

public class CreateAccessoriesCommand implements Command {
    private AccessoriesService accessoriesService = AccessoriesServiceImpl.getInstance();


    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        AccessoriesType type = AccessoriesType.valueOf(model.findParameter("type").toUpperCase());
        try {
            accessoriesService.createAccessories(new Accessories(type));
            return "redirect:/app/accessories/list";
        } catch (ExistAccessoryException e) {
            errors.put("accessories_error", e.getMessage());
        }

        model.setAttributes(errors);
        model.setAttribute("types", AccessoriesType.values());
        return "/views/accessories_create.jsp";
    }
}
