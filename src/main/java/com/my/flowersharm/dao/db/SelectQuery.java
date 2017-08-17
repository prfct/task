package com.my.flowersharm.dao.db;


import com.my.flowersharm.dao.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Stein on 15.05.17.
 */
public abstract class SelectQuery<T> implements DataCommand<T> {
    private Connection connection = DataSource.getInstance().getConnection();
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public T execute() {
        String sql = getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setupStatement(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            return parseResultSet(resultSet);
        } catch (SQLException e) {
            LOGGER.warn("Select query. execute ps problem '{}'", e.getMessage());
            throw new DaoException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.warn("Select query.cant close conn '{}'", e.getMessage());
            }
        }
    }

    protected abstract String getQuery();

    protected abstract void setupStatement(PreparedStatement preparedStatement) throws SQLException;

    protected abstract T parseResultSet(ResultSet resultSet) throws SQLException;
}
