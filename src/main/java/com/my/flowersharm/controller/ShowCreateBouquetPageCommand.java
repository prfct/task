package com.my.flowersharm.controller;


import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.model.domain.Tree;
import com.my.flowersharm.service.AccessoriesService;
import com.my.flowersharm.service.FlowerService;
import com.my.flowersharm.service.TreeService;
import com.my.flowersharm.service.impl.AccessoriesServiceImpl;
import com.my.flowersharm.service.impl.FlowerServiceImpl;
import com.my.flowersharm.service.impl.TreeServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.List;

public class ShowCreateBouquetPageCommand implements Command {
    private FlowerService flowerService = FlowerServiceImpl.getInstance();
    private TreeService treeService = TreeServiceImpl.getInstance();
    private AccessoriesService accessoriesService = AccessoriesServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        List<Flower> flowers = flowerService.flowerList();
        List<Tree> trees = treeService.treeList();
        List<Accessories> accessories = accessoriesService.accessoriesList();
        if (flowers != null && trees != null) {
            model.setAttribute("trees", trees);
            model.setAttribute("flowers", flowers);
            model.setAttribute("accessories", accessories);
        }
        return "/views/bouquet_create.jsp";
    }
}
