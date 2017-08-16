package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.AccessoriesType;
import com.my.flowersharm.web.Model;

public class ShowCreateAccessoriesPageCommand implements Command {

    @Override
    public String execute(Model model) {
        model.setAttribute("types", AccessoriesType.values());
        return "/views/accessories_create.jsp";
    }
}
