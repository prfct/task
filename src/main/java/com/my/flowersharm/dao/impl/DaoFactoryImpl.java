package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.*;

public class DaoFactoryImpl extends DaoFactory {

    private DaoFactoryImpl() {
    }

    private static class InstanceHolder {
        private static final DaoFactoryImpl INSTANCE = new DaoFactoryImpl();
    }

    public static DaoFactory getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public BouquetDao getBouquetDao() {
        return new BouquetDaoImpl();
    }

    @Override
    public FlowerDao getFlowerDao() {
        return new FlowerDaoImpl();
    }

    @Override
    public AccessoriesDao getAccessoriesDao() {
        return new AccessoriesDaoImpl();
    }

    @Override
    public TreeDao getTreeDao() {
        return new TreeDaoImpl();
    }

    @Override
    public BouquetFlowerDao getBouquetFlowerDao() {
        return new BouquetFlowerDaoImpl();
    }

    @Override
    public BouquetTreeDao getBouquetTreeDao() {
        return new BouquetTreeDaoImpl();
    }
}
