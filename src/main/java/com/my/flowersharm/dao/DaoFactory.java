package com.my.flowersharm.dao;

import com.my.flowersharm.dao.impl.DaoFactoryImpl;
import com.my.flowersharm.model.domain.BouquetAccessories;
import com.my.flowersharm.model.domain.BouquetFlower;

public abstract class DaoFactory {
    public abstract BouquetDao getBouquetDao();
    public abstract FlowerDao getFlowerDao();
    public abstract AccessoriesDao getAccessoriesDao();
    public abstract TreeDao getTreeDao();
    public abstract BouquetFlowerDao getBouquetFlowerDao();
    public abstract BouquetTreeDao getBouquetTreeDao();
    public abstract BouquetAccessoryDao getBouquetAccessoryDao();

    public static DaoFactory getFactory() {
        return DaoFactoryImpl.getInstance();
    }

}
