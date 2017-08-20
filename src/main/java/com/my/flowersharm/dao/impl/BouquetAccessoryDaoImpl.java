package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.BouquetAccessoryDao;
import com.my.flowersharm.dao.commands.InsertBouquetAccessory;
import com.my.flowersharm.dao.commands.SelectBouquetAccessoriesByBouquet;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetAccessories;

import java.util.List;

public class BouquetAccessoryDaoImpl extends AbstractDao implements BouquetAccessoryDao {

    @Override
    public List<BouquetAccessories> findBouquetAccessoriesByBouquet(Bouquet bouquet) {
        return executeDataCommand(new SelectBouquetAccessoriesByBouquet(bouquet));
    }

    @Override
    public BouquetAccessories createBouquetAccessory(Bouquet savedBouquet, BouquetAccessories bouquetAccessory) {
        return executeDataCommand(new InsertBouquetAccessory(savedBouquet, bouquetAccessory));
    }
}
