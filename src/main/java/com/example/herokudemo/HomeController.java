package com.example.herokudemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping({"", "/"})
    public String home() {
        return "hello";
    }

    @GetMapping("/all")
    public List<Question> findAllQuestions() {
        questionRepository.save(new Question("jaka jest szansa"));
        return questionRepository.findAll();
    }
}
