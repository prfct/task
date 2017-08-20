package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetAccessories;

import java.util.List;


public interface BouquetAccessoryDao {
    List<BouquetAccessories> findBouquetAccessoriesByBouquet(Bouquet bouquet);

    BouquetAccessories createBouquetAccessory(Bouquet savedBouquet, BouquetAccessories bouquetAccessory);
}
