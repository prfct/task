package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAllTree extends SelectQuery<List<Tree>> {
    public static final String QUERY = "SELECT * FROM tree";

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        //DO NOTHING
    }

    @Override
    protected List<Tree> parseResultSet(ResultSet resultSet) throws SQLException {
        List<Tree> trees = new ArrayList<>();
        while (resultSet.next()) {
            Tree tree = new Tree();
            tree.setId(resultSet.getLong("tree_id"));
            tree.setName(resultSet.getString("name"));
            tree.setSize(Size.valueOf(resultSet.getString("size")));
            trees.add(tree);
        }
        return trees;
    }
}
