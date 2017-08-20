package com.my.flowersharm.service.impl;

import com.my.flowersharm.dao.DaoFactory;
import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.Tree;
import com.my.flowersharm.service.AccessoriesService;
import com.my.flowersharm.service.exception.AccessoriesListException;
import com.my.flowersharm.service.exception.ExistAccessoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesServiceImpl implements AccessoriesService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private DaoFactory daoFactory = DaoFactory.getFactory();

    private AccessoriesServiceImpl() {
    }

    private static class InstanceHolder {
        private static final AccessoriesServiceImpl INSTANCE = new AccessoriesServiceImpl();
    }

    public static AccessoriesService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public List<Accessories> accessoriesList() {
        List<Accessories> accessories = daoFactory.getAccessoriesDao().getAll();
        if (accessories.isEmpty()) {
            LOGGER.warn("Service.There are no accessories");
        }
        LOGGER.info("Service. accessories size '{}'", accessories.size());
        return accessories;
    }

    @Override
    public Accessories createAccessories(Accessories accessories) throws ExistAccessoryException {
        Accessories existAccessory = daoFactory.getAccessoriesDao().findByType(accessories.getType());
        if (existAccessory != null) {
            LOGGER.warn("Service.Accessory with id '{}', type '{}' already created", existAccessory.getId(),
                    existAccessory.getType());
            throw new ExistAccessoryException("This accessory already created");
        }
        Accessories createdAccessories = daoFactory.getAccessoriesDao().createAccessories(accessories);
        LOGGER.info("Service.Accessories with id '{}', type '{}' successful created",
                createdAccessories.getId(), createdAccessories.getType());
        return createdAccessories;
    }

    @Override
    public List<Accessories> findByIds(List<Long> ids) {
        List<Accessories> list = new ArrayList<>();
        for (Long id : ids) {
            list.add(daoFactory.getAccessoriesDao().findById(id));
        }

        return list;
    }
}
