package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetTree;
import com.my.flowersharm.model.domain.Size;
import com.my.flowersharm.model.domain.Tree;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectBouquetsTreeByBouquet extends SelectQuery<List<BouquetTree>> {
    private static final String QUERY = "SELECT * FROM bouquet_tree bt " +
            "JOIN tree t ON bt.tree_id = t.tree_id " +
            "WHERE bouquet_id = ?";
    private Bouquet bouquet;

    public SelectBouquetsTreeByBouquet(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, bouquet.getId());
    }

    @Override
    protected List<BouquetTree> parseResultSet(ResultSet resultSet) throws SQLException {
        List<BouquetTree> bouquetTrees = new ArrayList<>();
        while (resultSet.next()) {
            BouquetTree bouquetTree = new BouquetTree();
            bouquetTree.setId(resultSet.getLong("bouquet_tree_id"));
            Tree tree = new Tree();
            tree.setId(resultSet.getLong("tree_id"));
            tree.setName(resultSet.getString("name"));
            tree.setSize(Size.valueOf(resultSet.getString("size")));
            bouquetTree.setTree(tree);
            bouquetTree.setBouquet(bouquet);
            bouquetTrees.add(bouquetTree);
        }
        return bouquetTrees;
    }
}
