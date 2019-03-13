package ink.organics.openjdk11;

import ink.organics.openjdk11.init.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class BootApplication {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootApplication.class);
        application.addListeners(new ApplicationStartup());
        application.run(args);
    }
}
