package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Flower;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SelectFlowersByBouquetId extends SelectQuery<List<Flower>> {
    private static final String QUERY = "SELECT * FROM bouquet_flower bf JOIN bouquet b ON f.bouquet_id = b.bouquet_id " +
            "WHERE bouquet_id = ?";
    private Long id;

    public SelectFlowersByBouquetId(Long id) {
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
    protected List<Flower> parseResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
