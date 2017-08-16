package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Size;
import com.my.flowersharm.web.Model;


public class ShowCreateTreePageCommand implements Command {

    @Override
    public String execute(Model model) {
        model.setAttribute("sizes", Size.values());
        return "/views/tree_create.jsp";
    }
}
