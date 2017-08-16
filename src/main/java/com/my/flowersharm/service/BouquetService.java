package com.my.flowersharm.service;

import com.my.flowersharm.model.domain.Bouquet;

import java.util.List;

public interface BouquetService {
    List<Bouquet> bouquetList();
    Bouquet createBouquet(Bouquet bouquet);

}
