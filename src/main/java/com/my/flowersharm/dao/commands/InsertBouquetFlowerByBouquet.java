package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.InsertQuery;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetFlower;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBouquetFlowerByBouquet extends InsertQuery<BouquetFlower> {
    public static final String QUERY = "INSERT INTO bouquet_flower (bouquet_id, flower_id, quantity) VALUES(?,?,?)";
    private Bouquet bouquet;
    private BouquetFlower bouquetFlower;

    public InsertBouquetFlowerByBouquet(Bouquet bouquet, BouquetFlower bouquetFlower) {
        this.bouquet = bouquet;
        this.bouquetFlower = bouquetFlower;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, bouquet.getId());
        preparedStatement.setLong(2, bouquetFlower.getFlower().getId());
        preparedStatement.setLong(3, bouquetFlower.getQuantity());
    }

    @Override
    protected BouquetFlower extractInserted(Long id) throws SQLException {
        bouquetFlower.setId(id);
        return bouquetFlower;
    }
}
