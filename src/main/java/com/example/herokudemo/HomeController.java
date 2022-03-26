package com.example.herokudemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return questionRepository.findAll();
    }

    @GetMapping("/all/count")
    public Integer getQuestionCount() {
        return questionRepository.countAll();
    }

    @PostMapping("/question")
    public Question newQuestion(@RequestBody Question question){
        return questionRepository.save(question);
    }
}
