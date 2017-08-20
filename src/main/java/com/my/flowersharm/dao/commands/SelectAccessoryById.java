package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.AccessoriesType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAccessoryById extends SelectQuery<Accessories> {
    public static final String QUERY = "SELECT * FROM accessories WHERE accessories_id = ?";
    private Long id;

    public SelectAccessoryById(Long id) {
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
    protected Accessories parseResultSet(ResultSet resultSet) throws SQLException {
        Accessories accessories = new Accessories();
        while (resultSet.next()) {
            accessories.setId(resultSet.getLong("accessories_id"));
            accessories.setType(AccessoriesType.valueOf(resultSet.getString("type")));
        }
        return accessories;
    }
}
