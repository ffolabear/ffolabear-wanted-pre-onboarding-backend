package com.wanted.preonboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@EnableJpaAuditing
@SpringBootApplication
public class WantedPreOnboardingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WantedPreOnboardingBackendApplication.class, args);
    }

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver"); // H2 DB Driver를 지정해줌
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"); // mem은 메모리 모드로 사용
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

}
