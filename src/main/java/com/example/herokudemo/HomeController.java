package com.example.herokudemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @GetMapping("/random/{number}")
    public List<Question> getRandom(@PathVariable int number) {
        Random random = new Random();
        List<Question> randomQuestions = new ArrayList<>();
        List<Question> questions = questionRepository.findAll();
        long questionCount = questionRepository.count();
        for (int i = 0; i < number; i++) {
            randomQuestions.add(questions.get(random.nextInt(0, (int)questionCount)));
        }
        return randomQuestions;

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
    public Question newQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }
}
