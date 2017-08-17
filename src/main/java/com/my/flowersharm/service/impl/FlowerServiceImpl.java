package com.my.flowersharm.service.impl;

import com.my.flowersharm.dao.DaoFactory;
import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.service.FlowerService;
import com.my.flowersharm.service.exception.FlowerListException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private DaoFactory daoFactory = DaoFactory.getFactory();

    private FlowerServiceImpl() {
    }

    private static class InstanceHolder {
        private static final FlowerServiceImpl INSTANCE = new FlowerServiceImpl();
    }

    public static FlowerService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public List<Flower> flowerList() {
        List<Flower> flowers = daoFactory.getFlowerDao().getAll();
        if (flowers.isEmpty()) {
            LOGGER.warn("Service.There are no flowers");
        }
        LOGGER.info("Service. Quantity Flowers in list '{}'", flowers.size());
        return flowers;
    }

    @Override
    public Flower createFlower(Flower flower) {
        Flower createdFlower = daoFactory.getFlowerDao().createFlower(flower);
        LOGGER.info("Service.Flower with id '{}', name '{}', colour '{}', freshness '{}', size '{}' successful created",
                createdFlower.getId(), createdFlower.getName(), createdFlower.getColour(),
                createdFlower.getFreshness(), createdFlower.getSize());
        return createdFlower;
    }

}
