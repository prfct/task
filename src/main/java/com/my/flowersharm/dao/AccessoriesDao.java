package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.AccessoriesType;

import java.util.List;

public interface AccessoriesDao {
    Accessories createAccessories(Accessories accessories);
    Accessories findByType(AccessoriesType type);
    List<Accessories> getAll();
}
