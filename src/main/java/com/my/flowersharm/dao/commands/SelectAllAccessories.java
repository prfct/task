package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.AccessoriesType;
import com.my.flowersharm.model.domain.Size;
import com.my.flowersharm.model.domain.Tree;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAllAccessories extends SelectQuery<List<Accessories>> {
    public static final String QUERY = "SELECT * FROM accessories";

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        //DO NOTHING
    }

    @Override
    protected List<Accessories> parseResultSet(ResultSet resultSet) throws SQLException {
        List<Accessories> accessories = new ArrayList<>();
        while (resultSet.next()) {
            Accessories accessory = new Accessories();
            accessory.setId(resultSet.getLong("accessories_id"));
            accessory.setType(AccessoriesType.valueOf(resultSet.getString("type")));
            accessories.add(accessory);
        }
        return accessories;
    }
}
