package com.my.flowersharm.controller;

import com.my.flowersharm.controller.parsers.LongParser;
import com.my.flowersharm.controller.parsers.NameParser;
import com.my.flowersharm.controller.parsers.Parser;
import com.my.flowersharm.model.domain.*;
import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.*;

public class CreateBouquetCommand implements Command {
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        Bouquet bouquet = new Bouquet();
        String title = model.findParameter("title", new NameParser(errors));
        Long price = model.findParameter("price", new LongParser(errors));
        bouquet.setFlowerList(model.findParameter("flowersQuantity", new BouquetFlowerParser()));
        List<BouquetFlower> bouquetFlowerList = new ArrayList<>();

        if (errors.isEmpty()) {
            bouquetService.createBouquet(new Bouquet());
            return "redirect:/app/flower/list";
        }
        model.setAttributes(errors);
        model.setAttribute("freshness", Freshness.values());
        model.setAttribute("steams", Steam.values());
        model.setAttribute("colours", Colour.values());
        return "/views/flower_create.jsp";
    }

    private class BouquetFlowerParser extends Parser<List<BouquetFlower>> {
        List<BouquetFlower> bouquetFlowerList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        @Override
        public List<BouquetFlower> parse(String key, String[] params) {
            return null;
        }

    }
}
