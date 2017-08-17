package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.BouquetAccessoryDao;
import com.my.flowersharm.dao.commands.SelectBouquetAccessoriesByBouquet;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetAccessories;

import java.util.Set;

public class BouquetAccessoryDaoImpl extends AbstractDao implements BouquetAccessoryDao {

    @Override
    public Set<BouquetAccessories> findBouquetAccessoriesByBouquet(Bouquet bouquet) {
        return executeDataCommand(new SelectBouquetAccessoriesByBouquet(bouquet));
    }
}
