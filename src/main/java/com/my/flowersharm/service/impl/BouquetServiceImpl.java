package com.my.flowersharm.service.impl;

import com.my.flowersharm.dao.DaoFactory;
import com.my.flowersharm.model.domain.*;
import com.my.flowersharm.service.BouquetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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
        return factory.getBouquetDao().readAll();
    }

    @Override
    public Bouquet createBouquet(Bouquet bouquet) {
        Bouquet savedBouquet = factory.getBouquetDao().create(bouquet);
        List<BouquetFlower> savedBouquetFlowerList = new ArrayList<>();
        List<BouquetTree> savedBouquetTreeList = new ArrayList<>();
        List<BouquetAccessories> savedBouquetAccessoriesList = new ArrayList<>();
        for (BouquetFlower bouquetFlower : savedBouquet.getFlowerList()) {
            BouquetFlower savedBouquetFlower = factory.getBouquetFlowerDao()
                    .createBouquetFlower(savedBouquet, bouquetFlower);
            savedBouquetFlowerList.add(savedBouquetFlower);
        }
        savedBouquet.setFlowerList(savedBouquetFlowerList);

        for (BouquetTree bouquetTree : savedBouquet.getTreeList()) {
            BouquetTree savedBouquetTree = factory.getBouquetTreeDao()
                    .createBouquetTree(savedBouquet, bouquetTree);
            savedBouquetTreeList.add(savedBouquetTree);
        }
        savedBouquet.setTreeList(savedBouquetTreeList);

        for (BouquetAccessories bouquetAccessory : savedBouquet.getAccessoriesList()) {
            BouquetAccessories savedBouquetAccessory = factory.getBouquetAccessoryDao()
                    .createBouquetAccessory(savedBouquet, bouquetAccessory);
            savedBouquetAccessoriesList.add(savedBouquetAccessory);
        }
        savedBouquet.setAccessoriesList(savedBouquetAccessoriesList);

        return savedBouquet;
    }

    @Override
    public Bouquet findBouquetById(Long bouquetId) {
        Bouquet bouquet = factory.getBouquetDao().findOne(bouquetId);
        List<BouquetFlower> flowers = factory.getBouquetFlowerDao().findBouquetFlowersByBouquet(bouquet);
        flowers.sort((o1, o2) -> o2.getFlower().getFreshness().compareTo(o1.getFlower().getFreshness()));
        if (bouquet != null) {
            bouquet.setFlowerList(flowers);
            bouquet.setTreeList(factory.getBouquetTreeDao().findBouquetTreesByBouquet(bouquet));
            bouquet.setAccessoriesList(factory.getBouquetAccessoryDao().findBouquetAccessoriesByBouquet(bouquet));
        }
        return bouquet;
    }

    @Override
    public Bouquet sortFlowersInBouquet(Long id) {
        Bouquet bouquet = factory.getBouquetDao().findOne(id);
        List<BouquetFlower> flowers = factory.getBouquetFlowerDao().findBouquetFlowersByBouquet(bouquet);
        flowers.sort(Comparator.comparing(o -> o.getFlower().getFreshness()));
        if (bouquet != null) {
            bouquet.setFlowerList(flowers);
            bouquet.setTreeList(factory.getBouquetTreeDao().findBouquetTreesByBouquet(bouquet));
            bouquet.setAccessoriesList(factory.getBouquetAccessoryDao().findBouquetAccessoriesByBouquet(bouquet));
        }
        return bouquet;
    }

    @Override
    public List<Flower> findFlowersInDiapasonById(Long id, Long from, Long to) {
        Bouquet bouquet = factory.getBouquetDao().findOne(id);
        List<BouquetFlower> flowers = factory.getBouquetFlowerDao().findBouquetFlowersByBouquet(bouquet);
        List<Flower> flowersInCurrentDiapason = new ArrayList<>();
        for (BouquetFlower flower : flowers) {
            if (flower.getFlower().getSize() > from && flower.getFlower().getSize() < to) {
                flowersInCurrentDiapason.add(flower.getFlower());
            }
        }
        return flowersInCurrentDiapason;
    }

}
