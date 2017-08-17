package com.my.flowersharm.controller;

import com.my.flowersharm.controller.parsers.IntegerParser;
import com.my.flowersharm.controller.parsers.NameParser;
import com.my.flowersharm.model.domain.*;
import com.my.flowersharm.service.FlowerService;
import com.my.flowersharm.service.impl.FlowerServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateFlowerCommand implements Command {
    private FlowerService flowerService = FlowerServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        String name = model.findParameter("name", new NameParser(errors));
        Integer size = model.findParameter("size", new IntegerParser(errors));
        Freshness freshness = Freshness.valueOf(model.findParameter("freshType"));
        Colour colour = Colour.valueOf(model.findParameter("colour"));
        if (errors.isEmpty()) {
            flowerService.createFlower(new Flower(name, colour, freshness, size));
            return "redirect:/app/flower/list";
        }
        model.setAttributes(errors);
        model.setAttribute("freshness", Freshness.values());
        model.setAttribute("steams", Steam.values());
        model.setAttribute("colours", Colour.values());
        return "/views/flower_create.jsp";
    }

}
