package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetTree;

import java.util.List;

public interface BouquetTreeDao {
    List<BouquetTree> findBouquetTreesByBouquet(Bouquet  bouquet);

}
