package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Colour;
import com.my.flowersharm.model.domain.Freshness;
import com.my.flowersharm.model.domain.Steam;
import com.my.flowersharm.web.Model;


public class ShowCreateFlowerPageCommand implements Command {

    @Override
    public String execute(Model model) {
        model.setAttribute("freshness", Freshness.values());
        model.setAttribute("steams", Steam.values());
        model.setAttribute("colours", Colour.values());
        return "/views/flower_create.jsp";
    }
}
