package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Bouquet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAllBouquets extends SelectQuery<List<Bouquet>> {
    private static final String QUERY = "SELECT * FROM bouquet";

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        //do nothing
    }

    @Override
    protected List<Bouquet> parseResultSet(ResultSet resultSet) throws SQLException {
        List<Bouquet> bouquets = new ArrayList<>();
        while (resultSet.next()) {
            Bouquet bouquet = new Bouquet();
            bouquet.setId(resultSet.getLong("bouquet_id"));
            bouquet.setTitle(resultSet.getString("title"));
            bouquet.setPrice(resultSet.getLong("price"));
            bouquets.add(bouquet);
        }
        return bouquets;
    }
}
