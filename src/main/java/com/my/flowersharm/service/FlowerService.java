package com.my.flowersharm.service;

import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.service.exception.FlowerListException;

import java.util.List;

public interface FlowerService {
    List<Flower> flowerList();

    Flower createFlower(Flower flower);

    Flower findFlowerById(Long id);
}
