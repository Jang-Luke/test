package com.example.demo.commons;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MySqlConnection implements DataSource {

    private static final HikariConfig hikariConfig = new HikariConfig("/properties/datasource.properties");
    private static final HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

    public static Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }
}
