package com.bakery.management;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("hideutilityclassconstructor")
@SpringBootApplication()
@ComponentScan({"com.bakery.management", "com.bakery.management.dao"})
@EntityScan("com.bakery.management.domain")
@EnableJpaRepositories("com.bakery.management.repository")
public class Application {

//    /***
//     * Class private constructor.
//     */
//    private Application() {
//    }

    /***
     * Application entry point, main method.
     * @param args application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class);
    }

    /***
     * Builds and OpeAPI as bean.
     * @param appDescription description of the application
     * @param appVersion version number of the application
     * @return OpenAPI object
     */
    // todo: appVersion placeholder produces warning in application.properties
    @Bean
    public OpenAPI customOpenAPI(
            @Value("${spring.application.name}") final String appDescription,
            @Value("${application-version}") final String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Bakery Management Application API")
                        .version(appVersion)
                        .description(appDescription)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }

    /***
     * Event listener to execute tasks after the application is ready.
     */
    @EventListener({ApplicationReadyEvent.class})
    public void applicationReadyEvent() {
        browse("http://localhost:8080/swagger-ui.html");

        // That will return error response because the graphql endpoint
        // accepts POST requests with valid json body. So, that is just
        // an example to start a browser.
        //browse("http://localhost:8080/graphql");
    }

    /***
     * Opens the default browser and loads the given url.
     * @param url url to open
     */
    @SuppressWarnings("SpellCheckingInspection")
    public static void browse(final String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
