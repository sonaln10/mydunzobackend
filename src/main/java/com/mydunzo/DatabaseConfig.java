package com.mydunzo;


import java.net.URISyntaxException;

//import org.apache.tomcat.jdbc.pool.DataSource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource ("file:src/main/resources/application.properties")
public class DatabaseConfig {

	@Bean
    @Primary
    @ConfigurationProperties ( prefix  ="spring.datasource")
    public  DataSource  dataSource (@Value("${spring.datasource.driver-class-name}") final String driverClass,
            @Value("${spring.datasource.url}") final String jdbcUrl,
            @Value("${spring.datasource.username}") final String username,
            @Value("${spring.datasource.password}") final String password,
            @Value("${spring.datasource.type}") final String type)throws URISyntaxException {
		
        
	    return DataSourceBuilder
               .create()
	            .username(username)
	            .password(password)
	            .url(jdbcUrl)
	            .driverClassName(driverClass)
	            .build();
    }
}
