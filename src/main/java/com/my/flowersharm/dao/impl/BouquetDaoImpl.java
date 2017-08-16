package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.BouquetDao;
import com.my.flowersharm.dao.commands.SelectAllBouquet;
import com.my.flowersharm.model.domain.Bouquet;

import java.util.List;

public class BouquetDaoImpl extends AbstractDao implements BouquetDao {

    @Override
    public List<Bouquet> readAll() {
        return executeDataCommand(new SelectAllBouquet());
    }

    @Override
    public Bouquet create(Bouquet bouquet) {
        return null;
    }
}