package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.InsertQuery;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetAccessories;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBouquetAccessory extends InsertQuery<BouquetAccessories> {
    public static final String QUERY = "INSERT INTO bouquet_accessories (bouquet_id, accessories_id) VALUES(?,?)";
    private Bouquet bouquet;
    private BouquetAccessories bouquetAccessory;

    public InsertBouquetAccessory(Bouquet bouquet, BouquetAccessories bouquetAccessory) {
        this.bouquet = bouquet;
        this.bouquetAccessory = bouquetAccessory;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, bouquet.getId());
        preparedStatement.setLong(2, bouquetAccessory.getAccessories().getId());
    }

    @Override
    protected BouquetAccessories extractInserted(Long id) throws SQLException {
        bouquetAccessory.setId(id);
        return bouquetAccessory;
    }
}
