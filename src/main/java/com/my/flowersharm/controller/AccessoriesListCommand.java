package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.Tree;
import com.my.flowersharm.service.AccessoriesService;
import com.my.flowersharm.service.TreeService;
import com.my.flowersharm.service.exception.AccessoriesListException;
import com.my.flowersharm.service.exception.TreeListException;
import com.my.flowersharm.service.impl.AccessoriesServiceImpl;
import com.my.flowersharm.service.impl.TreeServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessoriesListCommand implements Command {
    private AccessoriesService accessoriesService = AccessoriesServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        List<Accessories> accessories = accessoriesService.accessoriesList();
        if (accessories != null && !accessories.isEmpty()) {
            model.setAttribute("accessories", accessories);
        }else {
            errors.put("accessories_error", "There are no accessories");
            model.setAttributes(errors);
        }
        return "/views/accessories_list.jsp";
    }
}
