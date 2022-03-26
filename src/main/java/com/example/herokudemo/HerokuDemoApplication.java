package com.example.herokudemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HerokuDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HerokuDemoApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(QuestionRepository questionRepository){
        return args -> {
            questionRepository.save(new Question("cool beans"));
            questionRepository.save(new Question("jaka jest szansa"));
        };
    }
}
