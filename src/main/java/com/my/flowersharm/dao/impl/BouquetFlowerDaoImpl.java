package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.BouquetFlowerDao;
import com.my.flowersharm.dao.commands.SelectBouquetFlowersByBouquet;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetFlower;

import java.util.List;

public class BouquetFlowerDaoImpl extends AbstractDao implements BouquetFlowerDao  {
    @Override
    public List<BouquetFlower> findBouquetFlowersByBouquet(Bouquet bouquet) {
        return executeDataCommand(new SelectBouquetFlowersByBouquet(bouquet));
    }
}
