package com.my.flowersharm.controller;

import com.my.flowersharm.controller.parsers.LongParser;
import com.my.flowersharm.controller.parsers.NameParser;
import com.my.flowersharm.controller.parsers.Parser;
import com.my.flowersharm.controller.parsers.ParserMap;
import com.my.flowersharm.model.domain.*;
import com.my.flowersharm.service.AccessoriesService;
import com.my.flowersharm.service.BouquetService;
import com.my.flowersharm.service.FlowerService;
import com.my.flowersharm.service.TreeService;
import com.my.flowersharm.service.impl.AccessoriesServiceImpl;
import com.my.flowersharm.service.impl.BouquetServiceImpl;
import com.my.flowersharm.service.impl.FlowerServiceImpl;
import com.my.flowersharm.service.impl.TreeServiceImpl;
import com.my.flowersharm.web.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateBouquetCommand implements Command {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private BouquetService bouquetService = BouquetServiceImpl.getInstance();
    private FlowerService flowerService = FlowerServiceImpl.getInstance();
    private TreeService treeService = TreeServiceImpl.getInstance();
    private AccessoriesService accessoriesService = AccessoriesServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        Bouquet bouquet = new Bouquet();
        String title = model.findParameter("title", new NameParser(errors));
        Long price = model.findParameter("price", new LongParser(errors));
        bouquet.setTitle(title);
        bouquet.setPrice(price);
        bouquet.setFlowerList(model.findParameterMap(new BouquetFlowerParser()));
        bouquet.setTreeList(model.findParameterMap(new BouquetTreeParser()));
        bouquet.setAccessoriesList(model.findParameter("accessoryIds", new BouquetAccessoriesParser()));
        if (errors.isEmpty()) {
            bouquetService.createBouquet(bouquet);
            return "redirect:/app/bouquet/list";
        }
        model.setAttributes(errors);
        model.setAttribute("freshness", Freshness.values());
        model.setAttribute("steams", Steam.values());
        model.setAttribute("colours", Colour.values());
        return "/views/flower_create.jsp";
    }

    private class BouquetFlowerParser extends ParserMap<BouquetFlower> {
        private Pattern pattern = Pattern.compile("flowersQuantity\\[(\\d+)\\]");

        @Override
        public List<BouquetFlower> parse(Map<String, String[]> parameters) {
            List<BouquetFlower> list = new ArrayList<>();
            for (Map.Entry<String, String[]> stringEntry : parameters.entrySet()) {
                String[] params = stringEntry.getValue();
                Matcher matcher = pattern.matcher(stringEntry.getKey());
                if (matcher.matches()) {
                    if (params != null && params.length != 0) {
                        String param = params[0];
                        if (param != null && !param.isEmpty()) {
                            try {
                                Long flowerId = Long.parseLong(matcher.group(1));
                                Long quantity = Long.parseLong(param);
                                BouquetFlower bouquetFlower = new BouquetFlower();
                                bouquetFlower.setFlower(flowerService.findFlowerById(flowerId));
                                bouquetFlower.setQuantity(quantity);
                                list.add(bouquetFlower);
                            } catch (NumberFormatException e) {
                                LOGGER.warn(e.getMessage(), e);
                            }
                        }
                    }
                }
            }
            return list;
        }
    }

    private class BouquetTreeParser extends ParserMap<BouquetTree> {
        private Pattern pattern = Pattern.compile("treesQuantity\\[(\\d+)\\]");

        @Override
        public List<BouquetTree> parse(Map<String, String[]> parameters) {
            List<BouquetTree> list = new ArrayList<>();
            for (Map.Entry<String, String[]> stringEntry : parameters.entrySet()) {
                String[] params = stringEntry.getValue();
                Matcher matcher = pattern.matcher(stringEntry.getKey());
                if (matcher.matches()) {
                    if (params != null && params.length != 0) {
                        String param = params[0];
                        if (param != null && !param.isEmpty()) {
                            try {
                                Long treeId = Long.parseLong(matcher.group(1));
                                Long quantity = Long.parseLong(param);
                                BouquetTree bouquetTree = new BouquetTree();
                                bouquetTree.setTree(treeService.findTreeById(treeId));
                                bouquetTree.setQuantity(quantity);
                                list.add(bouquetTree);
                            } catch (NumberFormatException e) {
                                LOGGER.warn(e.getMessage(), e);
                            }
                        }
                    }
                }
            }
            return list;
        }
    }

    private class BouquetAccessoriesParser extends Parser<List<BouquetAccessories>> {

        @Override
        public List<BouquetAccessories> parse(String key, String[] params) {
            List<BouquetAccessories> bouquetAccessoriesList = new ArrayList<>();
            List<Long> ids = new ArrayList<>();
            if (params == null || params.length == 0) {
                return bouquetAccessoriesList;
            }
            for (String param : params) {
                ids.add(new Long(param));
            }
            List<Accessories> accessories = accessoriesService.findByIds(ids);
            for (Accessories accessory : accessories) {
                BouquetAccessories bouquetAccessories = new BouquetAccessories();
                bouquetAccessories.setAccessories(accessory);
                bouquetAccessoriesList.add(bouquetAccessories);
            }
            return bouquetAccessoriesList;
        }
    }
}
