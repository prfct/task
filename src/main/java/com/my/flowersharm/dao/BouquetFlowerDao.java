package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetFlower;

import java.util.List;

public interface BouquetFlowerDao {
    List<BouquetFlower> findBouquetFlowersByBouquet(Bouquet bouquet);
}
