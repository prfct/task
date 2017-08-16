package com.my.flowersharm.dao.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Stein on 15.05.17.
 */
public abstract class UpdateQuery<T> implements DataCommand<T> {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private DataSource instance = DataSource.getInstance();

    @Override
    public T execute() {
        String sql = getQuery();
        try (PreparedStatement preparedStatement = instance.getConnection().prepareStatement(sql)) {
            setupStatement(preparedStatement);
            preparedStatement.executeUpdate();
            return returnUpdatedObject();
        } catch (SQLException e) {
            LOGGER.warn("Update query. execute ps problem", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    protected abstract String getQuery();

    protected abstract void setupStatement(PreparedStatement preparedStatement) throws SQLException;

    protected abstract T returnUpdatedObject() throws SQLException;
}
