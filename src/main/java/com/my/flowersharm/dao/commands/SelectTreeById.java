package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Size;
import com.my.flowersharm.model.domain.Tree;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTreeById extends SelectQuery<Tree> {
    public static final String QUERY = "SELECT * FROM tree WHERE tree_id = ?";
    private Long treeId;

    public SelectTreeById(Long treeId) {
        this.treeId = treeId;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, treeId);
    }

    @Override
    protected Tree parseResultSet(ResultSet resultSet) throws SQLException {
        Tree tree = new Tree();
        while (resultSet.next()) {
            tree.setId(resultSet.getLong("tree_id"));
            tree.setName(resultSet.getString("name"));
            tree.setSize(Size.valueOf(resultSet.getString("size")));
        }
        return tree;
    }
}
