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
            questionRepository.save(new Question("cool beans", "hell yeah brother", true, "pam pam pam pam", false, "wann hast du geburtstag", false, "kebap", false));
            questionRepository.save(new Question("jaka jest szansa", "~27.3%", false, "duza", false, "durchfal", false, "to zalezy", true));
        };
    }
}
