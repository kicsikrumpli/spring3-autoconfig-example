package org.example.sqliteconfig;

import lombok.SneakyThrows;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

public class ConfigRepositoryBase {
    private final Connection connection;

    @SneakyThrows
    public ConfigRepositoryBase(SQLiteDataSource dataSource) {
        this.connection = dataSource.getConnection();
    }

    @SneakyThrows
    public ResultSet performQuery(
            String query,
            Object... parameters
    ) {
        PreparedStatement statement = this.connection.prepareStatement(query);
        IntStream.range(0, parameters.length).forEach(
                index -> {
                    try {
                        statement.setObject(index + 1, parameters[index]);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        return statement.executeQuery();
    }
    @SneakyThrows
    public String getLongTitleByTitle(String title) {
        String query = "SELECT LongTitle FROM works WHERE Title=?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, title);

        return statement.executeQuery().getString(1);
    }
}
