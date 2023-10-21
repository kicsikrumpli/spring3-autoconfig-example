package org.example.sqliteconfig.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sqliteconfig")
public class SqliteConfigProperties {
    private static final String DEFAULT_DB_LOCATION = "jdbc:sqlite::resource:conf.db";
    private String location = DEFAULT_DB_LOCATION;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
