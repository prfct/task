package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.service.FlowerService;
import com.my.flowersharm.service.exception.FlowerListException;
import com.my.flowersharm.service.impl.FlowerServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerListCommand implements Command {
    private FlowerService flowerService = FlowerServiceImpl.getInstance();


    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        List<Flower> flowers = flowerService.flowerList();
        if (flowers != null && !flowers.isEmpty()) {
            model.setAttribute("flowers", flowers);
        } else {
            errors.put("flowers_error", "There are no flowers");
            model.setAttributes(errors);
        }
        return "/views/flower_list.jsp";
    }
}
