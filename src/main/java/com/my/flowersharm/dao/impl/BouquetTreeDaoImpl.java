package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.BouquetTreeDao;
import com.my.flowersharm.dao.commands.InsertBouquetTree;
import com.my.flowersharm.dao.commands.SelectBouquetsTreeByBouquet;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetTree;

import java.util.List;

public class BouquetTreeDaoImpl  extends AbstractDao implements BouquetTreeDao {

    @Override
    public List<BouquetTree> findBouquetTreesByBouquet(Bouquet bouquet) {
        return executeDataCommand(new SelectBouquetsTreeByBouquet(bouquet));
    }

    @Override
    public BouquetTree createBouquetTree(Bouquet savedBouquet, BouquetTree bouquetTree) {
        return executeDataCommand(new InsertBouquetTree(savedBouquet, bouquetTree));
    }
}
