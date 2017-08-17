package com.my.flowersharm.dao.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Stein on 15.05.17.
 */
public abstract class InsertQuery<T> implements DataCommand<T> {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private Connection connection = DataSource.getInstance().getConnection();

    @Override
    public T execute() {
        String sql = getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setupStatement(preparedStatement);
            int status = preparedStatement.executeUpdate();
            if (status != 1) {
                LOGGER.warn("Creating failed, no rows affected.");
                throw new SQLException("Creating failed, no rows affected.");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long generatedId = generatedKeys.getLong(1);
                    return extractInserted(generatedId);
                } else {
                    LOGGER.warn("Creating failed, no ID obtained.");
                    throw new SQLException("Creating failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("Insert query. Execute ps problem '{}'", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.warn("Insert query. cant close conn '{}'", e.getMessage());

            }
        }
    }

    protected abstract String getQuery();

    protected abstract void setupStatement(PreparedStatement preparedStatement) throws SQLException;

    protected abstract T extractInserted(Long id) throws SQLException;
}
