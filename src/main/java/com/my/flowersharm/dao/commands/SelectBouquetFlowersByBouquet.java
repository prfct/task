package com.my.flowersharm.dao.commands;

import com.my.flowersharm.dao.db.SelectQuery;
import com.my.flowersharm.model.domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SelectBouquetFlowersByBouquet extends SelectQuery<List<BouquetFlower>> {
    private static final String QUERY = "SELECT * FROM bouquet_flower bf " +
            "JOIN flower f ON bf.flower_id = f.flower_id " +
            "WHERE bouquet_id = 1";
    private Bouquet bouquet;

    public SelectBouquetFlowersByBouquet(Bouquet bouquet) {
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
    protected List<BouquetFlower> parseResultSet(ResultSet resultSet) throws SQLException {
        List<BouquetFlower> bouquetFlowers = new ArrayList<>();
        while (resultSet.next()) {
            BouquetFlower bouquetFlower = new BouquetFlower();
            bouquetFlower.setId(resultSet.getLong("bouquet_flower_id"));
            bouquetFlower.setQuantity(resultSet.getLong("quantity"));
            Flower flower = new Flower();
            flower.setId(resultSet.getLong("flower_id"));
            flower.setName(resultSet.getString("name"));
            flower.setColour(Colour.valueOf(resultSet.getString("colour")));
            flower.setFreshness(Freshness.valueOf(resultSet.getString("freshness")));
            flower.setSteam(Steam.valueOf(resultSet.getString("stream")));
            bouquetFlower.setFlower(flower);
            bouquetFlowers.add(bouquetFlower);
        }
        return bouquetFlowers;
    }
}
