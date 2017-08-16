package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.FlowerDao;
import com.my.flowersharm.dao.commands.InsertFlower;
import com.my.flowersharm.dao.commands.SelectAllFlowers;
import com.my.flowersharm.dao.commands.SelectFlowersByBouquetId;
import com.my.flowersharm.model.domain.Flower;

import java.util.List;

public class FlowerDaoImpl extends AbstractDao implements FlowerDao {

    @Override
    public Flower createFlower(Flower flower) {
        return executeDataCommand(new InsertFlower(flower));
    }

    @Override
    public List<Flower> findFlowersByBouquetId(Long id) {
        return executeDataCommand(new SelectFlowersByBouquetId(id));
    }

    @Override
    public List<Flower> getAll() {
        return executeDataCommand(new SelectAllFlowers());
    }


}
