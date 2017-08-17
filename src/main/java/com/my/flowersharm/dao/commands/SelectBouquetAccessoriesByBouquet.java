package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.AccessoriesType;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetAccessories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class SelectBouquetAccessoriesByBouquet extends SelectQuery<Set<BouquetAccessories>> {
    private static final String QUERY = "SELECT * FROM bouquet_accessories ba " +
            "JOIN accessories a ON ba.accessories_id = a.accessories_id " +
            "WHERE bouquet_id = ?";
    private Bouquet bouquet;

    public SelectBouquetAccessoriesByBouquet(Bouquet bouquet) {
        this.bouquet = bouquet;
    }


    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, bouquet.getId());
    }

    @Override
    protected Set<BouquetAccessories> parseResultSet(ResultSet resultSet) throws SQLException {
        Set<BouquetAccessories> bouquetAccessories = new HashSet<>();
        while (resultSet.next()) {
            BouquetAccessories bouquetAccessory = new BouquetAccessories();
            bouquetAccessory.setId(resultSet.getLong("bouquet_accessories_id"));
            Accessories accessory = new Accessories();
            accessory.setId(resultSet.getLong("accessories_id"));
            accessory.setType(AccessoriesType.valueOf(resultSet.getString("type")));
            bouquetAccessory.setAccessories(accessory);
            bouquetAccessory.setBouquet(bouquet);
            bouquetAccessories.add(bouquetAccessory);
        }
        return bouquetAccessories;
    }
}
