package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetFlower;
import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.List;

public class DetailBouquetCommand implements Command {
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Long bouquetId = Long.parseLong(model.findParameter("id"));
        Bouquet bouquet = bouquetService.findBouquetById(bouquetId);
        if (bouquet != null) {
            model.setAttribute("bouquet", bouquet);
        }
        return "/views/bouquet_detail.jsp";
    }
}
