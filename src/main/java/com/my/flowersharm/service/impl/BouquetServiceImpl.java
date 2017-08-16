package com.my.flowersharm.service.impl;

import com.my.flowersharm.dao.DaoFactory;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetFlower;
import com.my.flowersharm.model.domain.BouquetTree;
import com.my.flowersharm.service.BouquetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BouquetServiceImpl implements BouquetService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private DaoFactory factory = DaoFactory.getFactory();


    private BouquetServiceImpl() {
    }

    private static class InstanceHolder {
        private static final BouquetServiceImpl INSTANCE = new BouquetServiceImpl();
    }

    public static BouquetService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public List<Bouquet> bouquetList() {
        List<Bouquet> bouquets = factory.getBouquetDao().readAll();
        for (Bouquet bouquet : bouquets) {
            List<BouquetFlower> bouquetFlowers = factory.getBouquetFlowerDao().findBouquetFlowersByBouquet(bouquet);
            List<BouquetTree> bouquetTrees = factory.getBouquetTreeDao().findBouquetTreesByBouquet(bouquet);
            bouquet.setFlowerList(bouquetFlowers);
            bouquet.setTreeList(bouquetTrees);
        }
        List<Bouquet> result = new ArrayList<>();
        return result;
    }

    @Override
    public Bouquet createBouquet(Bouquet bouquet) {
        return factory.getBouquetDao().create(new Bouquet());
    }
}
