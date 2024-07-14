package personal.codename;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import personal.codename.configurations.AppJwtProperties;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(AppJwtProperties.class)
public class CodenameApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodenameApplication.class, args);
    }

}
