package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAccessoryByType extends SelectQuery<Accessories> {
    private static final String QUERY = "SELECT * FROM accessories WHERE type = ?";
    private AccessoriesType type;


    public SelectAccessoryByType(AccessoriesType type) {
        this.type = type;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, type.getType());
    }

    @Override
    protected Accessories parseResultSet(ResultSet resultSet) throws SQLException {
        Accessories accessory = null;
        while (resultSet.next()) {
            accessory = new Accessories();
            accessory.setId(resultSet.getLong("accessories_id"));
            accessory.setType(AccessoriesType.valueOf(resultSet.getString("type")));
        }
        return accessory;
    }
}
