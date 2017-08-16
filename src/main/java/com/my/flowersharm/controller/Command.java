package com.my.flowersharm.controller;

import com.my.flowersharm.web.Model;

public interface Command {
    String execute(Model model);
}
