package com.my.flowersharm.controller;

import com.my.flowersharm.controller.parsers.LongParser;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiapasonFlowers implements Command {
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        Long id = Long.parseLong(model.findParameter("id"));
        Long from = model.findParameter("from", new LongParser(errors));
        Long to = model.findParameter("to", new LongParser(errors));
        if (!errors.isEmpty()){
            Bouquet bouquet = bouquetService.findBouquetById(id);
            model.setAttributes(errors);
            model.setAttribute("failedFrom", model.findParameter("from"));
            model.setAttribute("failedTo", model.findParameter("to"));
            model.setAttribute("bouquet", bouquet);
            return "/views/bouquet_detail.jsp";
        }
        List<Flower> flowers = bouquetService.findFlowersInDiapasonById(id, from, to);
        if (flowers != null && !flowers.isEmpty()) {
            model.setAttribute("flowers", flowers);
        } else {
            errors.put("flowers_error", "There are no flowers in current diapason");
            model.setAttributes(errors);
        }
        return "/views/flower_list.jsp";
    }
}
