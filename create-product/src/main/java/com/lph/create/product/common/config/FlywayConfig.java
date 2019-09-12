package com.lph.create.product.common.config;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class FlywayConfig {

    private static final String FLYWAY_TAB_NAME = "product_flyway_schema_history";

    private static final String FLYWAY_LOCATION = "db/migration";

    public FlywayConfig(SpringContextProvider provider) {
        Flyway defFlyway = null;
        try {
            defFlyway = provider.getBean(Flyway.class);
        } catch (Exception e) {
            log.warn("flyway is not enabled.");
        }
        if (defFlyway != null) {
            migrate(defFlyway);
        }

    }

    @SuppressWarnings("deprecation")
    public void migrate(Flyway defFlyway) {
        FluentConfiguration config = new FluentConfiguration();
        config.dataSource(defFlyway.getDataSource())
        .baselineOnMigrate(defFlyway.isBaselineOnMigrate())
        .locations(FLYWAY_LOCATION)
        .table(FLYWAY_TAB_NAME)
        //允许运行之前版本（相对于schema表最新版本）的schema文件
        .outOfOrder(true)
        .load()
        .migrate();
    }

}
