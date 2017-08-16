package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.InsertQuery;
import com.my.flowersharm.model.domain.Flower;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFlower extends InsertQuery<Flower> {
    private static final String QUERY = "INSERT INTO flower (name, colour, freshness, steam) VALUES (?,?,?,?)";
    private Flower flower;

    public InsertFlower(Flower flower) {
        this.flower = flower;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, flower.getName());
        preparedStatement.setString(2, flower.getColour().toString());
        preparedStatement.setString(3, flower.getFreshness().toString());
        preparedStatement.setString(4, flower.getSteam().toString());

    }

    @Override
    protected Flower extractInserted(Long id) throws SQLException {
        flower.setId(id);
        return flower;
    }
}
