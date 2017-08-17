package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Bouquet;

import java.util.List;

public interface BouquetDao {
    List<Bouquet> readAll();

    Bouquet create(Bouquet bouquet);

    Bouquet findOne(Long bouquetId);
}
