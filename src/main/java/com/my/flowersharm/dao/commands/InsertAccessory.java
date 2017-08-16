package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.InsertQuery;
import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.model.domain.Tree;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAccessory extends InsertQuery<Accessories> {
    private static final String QUERY = "INSERT INTO accessories (type) VALUES (?)";
    private Accessories accessories;

    public InsertAccessory(Accessories accessories) {
        this.accessories = accessories;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, accessories.getType().toString());

    }

    @Override
    protected Accessories extractInserted(Long id) throws SQLException {
        accessories.setId(id);
        return accessories;
    }
}
