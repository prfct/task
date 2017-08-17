package com.my.flowersharm.controller;

import com.my.flowersharm.controller.parsers.LongParser;
import com.my.flowersharm.controller.parsers.NameParser;
import com.my.flowersharm.controller.parsers.ParserMap;
import com.my.flowersharm.model.domain.*;
import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateBouquetCommand implements Command {
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        Bouquet bouquet = new Bouquet();
        String title = model.findParameter("title", new NameParser(errors));
        Long price = model.findParameter("price", new LongParser(errors));
        model.findParameterMap(new BouquetFlowerParser());

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

    private class BouquetFlowerParser extends ParserMap<Long, BouquetFlower> {
        private Pattern pattern = Pattern.compile("(\\w)\\w+");
        List<Long> ids = new ArrayList<>();
        Map<Long, BouquetFlower> map = new HashMap<>();

        @Override
        public Map<Long, BouquetFlower> parse(Map<String, String[]> parameters) {
            for (Map.Entry<String, String[]> stringEntry : parameters.entrySet()) {
                String[] params = stringEntry.getValue();
                Integer value = null;
                Matcher matcher = pattern.matcher(stringEntry.getKey());
                if (matcher.matches()) {
                    Long key = Long.parseLong(matcher.group(1));
                    ids.add(key);
                }
            }
            return map;
        }
    }
}
