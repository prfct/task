package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Colour;
import com.my.flowersharm.model.domain.Flower;
import com.my.flowersharm.model.domain.Freshness;
import com.my.flowersharm.model.domain.Steam;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAllFlowers extends SelectQuery<List<Flower>> {
    public static final String QUERY = "SELECT * FROM flower";

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        //DO NOTHING
    }

    @Override
    protected List<Flower> parseResultSet(ResultSet resultSet) throws SQLException {
        List<Flower> flowers = new ArrayList<>();
        while (resultSet.next()) {
            Flower flower = new Flower();
            flower.setId(resultSet.getLong("flower_id"));
            flower.setName(resultSet.getString("name"));
            flower.setColour(Colour.valueOf(resultSet.getString("colour")));
            flower.setFreshness(Freshness.valueOf(resultSet.getString("freshness")));
            flower.setSteam(Steam.valueOf(resultSet.getString("steam")));
            flowers.add(flower);
        }
        return flowers;
    }
}
