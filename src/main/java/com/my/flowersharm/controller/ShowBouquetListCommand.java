package com.my.flowersharm.controller;


import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.FlowerService;
import com.my.flowersharm.service.TreeService;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.service.impl.FlowerServiceImpl;
import com.my.flowersharm.service.impl.TreeServiceImpl;
import com.my.flowersharm.web.Model;


public class ShowBouquetListCommand implements Command {
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();
    private FlowerService flowerService = FlowerServiceImpl.getInstance();
    private TreeService treeService = TreeServiceImpl.getInstance();

    @Override
    public String execute(Model model) {

        bouquetService.bouquetList();
        return "/views/bouquet_list.jsp";
    }
}
