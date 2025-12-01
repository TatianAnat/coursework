package org.skypro.question.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.question.JavaQuestionService;
import org.skypro.question.Question;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaQuestionServiceTest {

    private JavaQuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
        questionService.addQuestion(new Question("What is Java?", "A programming language"));
        questionService.addQuestion(new Question("What is JVM?", "Java Virtual Machine"));
        questionService.addQuestion(new Question("What is JDK?", "Java Development Kit"));
    }

    @Test
    void addAndFindAllQuestions() {
        List<Question> all = questionService.findAllQuestions();
        assertThat(all).hasSize(3);
        assertThat(all).extracting(Question::getQuestion)
                .containsExactlyInAnyOrder("What is Java?", "What is JVM?", "What is JDK?");
    }

    @Test
    void removeQuestion() {
        boolean removed = questionService.removeQuestion(new Question("What is JVM?", "Java Virtual Machine"));
        assertThat(removed).isTrue();
        List<Question> all = questionService.findAllQuestions();
        assertThat(all).hasSize(2);
        assertThat(all).extracting(Question::getQuestion)
                .doesNotContain("What is JVM?");
    }

    @Test
    void getRandomQuestion() {
        Question randomQuestion = questionService.getRandomQuestion();
        assertThat(randomQuestion).isNotNull();
        assertThat(questionService.findAllQuestions()).contains(randomQuestion);
    }
}