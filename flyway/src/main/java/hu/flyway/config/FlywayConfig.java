package hu.flyway.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("develop")
@Configuration
public class FlywayConfig {

    @Bean
    public FlywayMigrationStrategy cleanAndRebuild(){
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }

}
