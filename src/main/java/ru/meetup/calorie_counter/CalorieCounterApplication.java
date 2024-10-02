package ru.meetup.calorie_counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.meetup.calorie_counter.*.dao.repository")
public class CalorieCounterApplication {

    public static void main(String... args) {
        SpringApplication.run(CalorieCounterApplication.class);
    }
}