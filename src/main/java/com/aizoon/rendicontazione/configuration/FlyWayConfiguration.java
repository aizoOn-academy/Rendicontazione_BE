package com.aizoon.rendicontazione.configuration;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayConfiguration {

    @Bean
    public FlywayMigrationStrategy repairMigrateStrategy() {
        return (flyway) -> {
            flyway.repair();
            flyway.migrate();
        };
    }

}