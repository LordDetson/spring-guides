package by.babanin.springboot.schedulingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The @EnableScheduling annotation ensures that a background task executor is created. Without it, nothing gets scheduled.
 */

@SpringBootApplication
@EnableScheduling
public class SchedulingTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingTasksApplication.class, args);
    }

}
