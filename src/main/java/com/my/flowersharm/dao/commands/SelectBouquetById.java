package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Bouquet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectBouquetById extends SelectQuery<Bouquet> {
    public static final String QUERY = "SELECT * FROM BOUQUET WHERE bouquet_id = ?";
    private Long bouquetId;

    public SelectBouquetById(Long bouquetId) {
        this.bouquetId = bouquetId;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, bouquetId);
    }

    @Override
    protected Bouquet parseResultSet(ResultSet resultSet) throws SQLException {
        Bouquet bouquet = null;
        while (resultSet.next()) {
            bouquet = new Bouquet();
            bouquet.setId(resultSet.getLong("bouquet_id"));
            bouquet.setTitle(resultSet.getString("title"));
            bouquet.setPrice(resultSet.getLong("price"));
        }
        return bouquet;
    }
}
