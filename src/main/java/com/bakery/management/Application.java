package com.bakery.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan({"com.bakery.management", "com.bakery.management.dao"})
@EntityScan("com.bakery.management.domain")
@EnableJpaRepositories("com.bakery.management.repository")
public class Application {

    /***
     * Class private constructor.
     */
    private Application() {
    }

    /***
     * Application entry point, main method.
     */
    public static void main() {
        SpringApplication.run(Application.class);
    }

}
