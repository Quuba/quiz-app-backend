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

    public Question() {
    }

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public boolean isCorrect1() {
        return isCorrect1;
    }

    public void setCorrect1(boolean correct1) {
        isCorrect1 = correct1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public boolean isCorrect2() {
        return isCorrect2;
    }

    public void setCorrect2(boolean correct2) {
        isCorrect2 = correct2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public boolean isCorrect3() {
        return isCorrect3;
    }

    public void setCorrect3(boolean correct3) {
        isCorrect3 = correct3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public boolean isCorrect4() {
        return isCorrect4;
    }

    public void setCorrect4(boolean correct4) {
        isCorrect4 = correct4;
    }
}

interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findById(int id);
    List<Question> findAll();
};