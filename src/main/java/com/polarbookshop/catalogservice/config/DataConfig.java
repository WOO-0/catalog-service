package com.polarbookshop.catalogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@Configuration
@EnableJdbcAuditing
public class DataConfig {
    // This class is intentionally left empty.
    // It is used to indicate that the application should use the default data configuration.
    // The Spring Boot application will automatically configure the necessary data components.
}