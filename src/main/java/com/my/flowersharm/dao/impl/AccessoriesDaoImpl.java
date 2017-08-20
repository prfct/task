package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.AccessoriesDao;
import com.my.flowersharm.dao.commands.*;
import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.AccessoriesType;

import java.util.List;

public class AccessoriesDaoImpl extends AbstractDao implements AccessoriesDao {
    @Override
    public Accessories createAccessories(Accessories accessories) {
        return executeDataCommand(new InsertAccessory(accessories));
    }

    @Override
    public Accessories findByType(AccessoriesType type) {
        return executeDataCommand(new SelectAccessoryByType(type));
    }

    @Override
    public List<Accessories> getAll() {
        return executeDataCommand(new SelectAllAccessories());
    }

    @Override
    public Accessories findById(Long id) {
        return executeDataCommand(new SelectAccessoryById(id));
    }
}
