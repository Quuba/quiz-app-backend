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

    @CrossOrigin("*")
    @GetMapping("/all")
    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }
    @CrossOrigin("*")

    @GetMapping("/all/{id}")
    public Question findQuestion(@PathVariable int id) {
        return questionRepository.findById(id);
    }

    @CrossOrigin("*")
    @DeleteMapping("/all/{id}")
    public void deleteQuestion(@PathVariable int id) {
        questionRepository.deleteById(id);
    }

    @CrossOrigin("*")
    @GetMapping("/all/count")
    public long getQuestionCount() {
        return questionRepository.count();
    }

    @CrossOrigin("*")
    @PostMapping("/question")
    public Question newQuestion(@RequestBody Question question){
        return questionRepository.save(question);
    }
}
