package org.example.sqliteconfig.autoconfig;

import org.example.sqliteconfig.ConfigRepositoryBase;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.sqlite.SQLiteDataSource;

@AutoConfiguration
@ConditionalOnClass(ConfigRepositoryBase.class)
@EnableConfigurationProperties(SqliteConfigProperties.class)
public class SqliteConfigAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SQLiteDataSource sqLiteDataSource(SqliteConfigProperties sqliteConfigProperties) {
        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(sqliteConfigProperties.getLocation());
        return sqLiteDataSource;
    }
    @Bean
    @ConditionalOnMissingBean
    public ConfigRepositoryBase configureDummyRepository(
            SQLiteDataSource sqLiteDataSource
    ) {
        return new ConfigRepositoryBase(sqLiteDataSource);
    }
}
