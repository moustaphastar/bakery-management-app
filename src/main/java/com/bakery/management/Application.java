package com.bakery.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("UtilityClass")
@SpringBootApplication()
@ComponentScan({"com.bakery.management", "com.bakery.management.dao"})
@EntityScan("com.bakery.management.domain")
@EnableJpaRepositories("com.bakery.management.repository")
public class Application {

    /***
     * Application entry point, main method.
     * @param args arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
