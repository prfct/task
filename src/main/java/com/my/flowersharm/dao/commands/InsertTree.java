package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.InsertQuery;
import com.my.flowersharm.model.domain.Tree;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTree extends InsertQuery<Tree> {
    private static final String QUERY = "INSERT INTO tree (name, size) VALUES (?,?)";
    private Tree tree;

    public InsertTree(Tree tree) {
        this.tree = tree;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, tree.getName());
        preparedStatement.setString(2, tree.getSize().toString());

    }

    @Override
    protected Tree extractInserted(Long id) throws SQLException {
        tree.setId(id);
        return tree;
    }
}
