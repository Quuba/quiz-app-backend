package com.example.herokudemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin("*")
    @GetMapping("/all/count")
    public long getQuestionCount() {
        return questionRepository.count();
    }

    @PostMapping("/question")
    public Question newQuestion(@RequestBody Question question){
        return questionRepository.save(question);
    }
}
