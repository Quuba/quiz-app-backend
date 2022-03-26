package com.example.herokudemo;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String questionText;

    String answer1;
    boolean isCorrect1;

    String answer2;
    boolean isCorrect2;

    String answer3;
    boolean isCorrect3;

    String answer4;
    boolean isCorrect4;

    public Question(String questionText) {
        this.questionText = questionText;
    }
}

interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findById(int id);
    List<Question> findAll();
};