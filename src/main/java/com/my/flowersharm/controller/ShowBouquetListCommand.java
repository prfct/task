package com.my.flowersharm.controller;

import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.web.Model;

public class ShowBouquetListCommand implements Command {
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        model.setAttribute("bouquets", bouquetService.bouquetList());
        return "/views/bouquet_list.jsp";
    }
}
