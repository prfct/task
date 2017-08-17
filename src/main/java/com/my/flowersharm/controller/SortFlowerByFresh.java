package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.web.Model;

public class SortFlowerByFresh implements Command {
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Long id = Long.parseLong(model.findParameter("bouId"));
        Bouquet bouquet = bouquetService.sortFlowersInBouquet(id);
        if (bouquet != null) {
            model.setAttribute("bouquet", bouquet);
        }
        return "/views/bouquet_detail.jsp";
    }
}
