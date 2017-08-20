package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Colour;
import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.model.domain.Freshness;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectFlowerById extends SelectQuery<Flower> {
    public static final String QUERY = "SELECT * FROM flower WHERE flower_id = ?";
    private Long id;

    public SelectFlowerById(Long id) {
        this.id = id;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, id);

    }

    @Override
    protected Flower parseResultSet(ResultSet resultSet) throws SQLException {
        Flower flower = new Flower();
        while (resultSet.next()) {
            flower.setId(resultSet.getLong("flower_id"));
            flower.setName(resultSet.getString("name"));
            flower.setColour(Colour.valueOf(resultSet.getString("colour")));
            flower.setFreshness(Freshness.valueOf(resultSet.getString("freshness")));
            flower.setSize(resultSet.getInt("steam"));
        }
        return flower;
    }
}
