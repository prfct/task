package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Colour;
import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.model.domain.Freshness;
import com.my.flowersharm.model.domain.Steam;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectFlowerByName extends SelectQuery<Flower> {
    private static final String QUERY = "SELECT * FROM flower WHERE name = ?";
    private String name;


    public SelectFlowerByName(String name) {
        this.name = name;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, name);
    }

    @Override
    protected Flower parseResultSet(ResultSet resultSet) throws SQLException {
        Flower flower = null;
        while (resultSet.next()) {
            flower = new Flower();
            flower.setId(resultSet.getLong("flower_id"));
            flower.setName(resultSet.getString("name"));
            flower.setColour(Colour.valueOf(resultSet.getString("colour")));
            flower.setFreshness(Freshness.valueOf(resultSet.getString("freshness")));
            flower.setSteam(Steam.valueOf(resultSet.getString("steam")));
        }
        return flower;
    }
}
