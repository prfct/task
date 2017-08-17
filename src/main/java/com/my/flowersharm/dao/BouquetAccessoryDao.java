package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetAccessories;

import java.util.Set;

public interface BouquetAccessoryDao {
    Set<BouquetAccessories> findBouquetAccessoriesByBouquet(Bouquet bouquet);
}
