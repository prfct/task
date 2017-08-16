package com.my.flowersharm.dao.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Stein on 17.05.17.
 */
public class DataSource {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static DataSource instance = new DataSource();
    private BasicDataSource basicDataSource;


    private DataSource() {
        initDataSource();
    }

    private void initDataSource() {
        basicDataSource = new BasicDataSource();
        Properties properties = new Properties();

        try (InputStream inStream = getClass().getResourceAsStream("/db.properties")) {
            properties.load(inStream);
            basicDataSource.setDriverClassName(properties.getProperty("driver.class"));
        } catch (IOException e) {
            throw new RuntimeException();

        }

        basicDataSource.setUrl(properties.getProperty("url"));
        basicDataSource.setUsername(properties.getProperty("user"));
        basicDataSource.setPassword(properties.getProperty("password"));
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.warn("Failed to get connection from datasource", e.getMessage());
            throw new RuntimeException();
        }
        return connection;
    }

    public static DataSource getInstance() {
        return instance;
    }

}
