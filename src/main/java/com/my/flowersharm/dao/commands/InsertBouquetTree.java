package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.InsertQuery;
import com.my.flowersharm.model.domain.Bouquet;
import com.my.flowersharm.model.domain.BouquetTree;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBouquetTree extends InsertQuery<BouquetTree> {
    public static final String QUERY = "INSERT INTO bouquet_tree(bouquet_id, tree_id, quantity) VALUES (?,?,?)";
    private Bouquet savedBouquet;
    private BouquetTree bouquetTree;

    public InsertBouquetTree(Bouquet savedBouquet, BouquetTree bouquetTree) {
        this.savedBouquet = savedBouquet;
        this.bouquetTree = bouquetTree;
    }

    @Override
    protected String getQuery() {
        return QUERY;
    }

    @Override
    protected void setupStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, savedBouquet.getId() );
        preparedStatement.setLong(2, bouquetTree.getTree().getId());
        preparedStatement.setLong(3, bouquetTree.getQuantity());
    }

    @Override
    protected BouquetTree extractInserted(Long id) throws SQLException {
        bouquetTree.setId(id);
        return bouquetTree;
    }
}
