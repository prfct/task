package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Flower;

import java.util.List;

public interface FlowerDao {
    Flower createFlower(Flower flower);

    List<Flower> findFlowersByBouquetId(Long id);

    List<Flower> getAll();

    Flower findFlowerById(Long id);
}
