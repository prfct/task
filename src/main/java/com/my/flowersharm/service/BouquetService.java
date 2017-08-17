package com.my.flowersharm.service;

import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetFlower;
import com.my.flowersharm.model.domain.Flower;

import java.util.List;

public interface BouquetService {
    List<Bouquet> bouquetList();
    Bouquet createBouquet(Bouquet bouquet);

    Bouquet findBouquetById(Long bouquetId);

    Bouquet sortFlowersInBouquet(Long id);

    List<Flower> findFlowersInDiapasonById(Long id, Long from, Long to);
}
