package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.InsertQuery;
import com.my.flowersharm.model.domain.Bouquet;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBouquet extends InsertQuery<Bouquet> {
    private static final String QUERY = "INSERT INTO bouquet(title, price) VALUES (?, ?)";
    private Bouquet bouquet;

    public InsertBouquet(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, bouquet.getTitle());
        preparedStatement.setLong(2, bouquet.getPrice());
    }

    @Override
    protected Bouquet extractInserted(Long id) throws SQLException {
        bouquet.setId(id);
        return bouquet;
    }
}
