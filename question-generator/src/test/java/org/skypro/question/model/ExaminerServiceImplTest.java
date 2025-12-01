package org.skypro.question.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.question.ExaminerServiceImpl;
import org.skypro.question.JavaQuestionService;
import org.skypro.question.Question;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExaminerServiceImplTest {

    private JavaQuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
        questionService.addQuestion(new Question("What is Java?", "A programming language"));
        questionService.addQuestion(new Question("What is JVM?", "Java Virtual Machine"));

        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getRandomUniqueQuestions_ReturnsUniqueExpectedNumber() {
        Set<Question> questions = examinerService.getRandomUniqueQuestions(2);
        assertThat(questions).hasSize(2);
    }

    @Test
    void getRandomUniqueQuestions_ThrowsWhenRequestMoreThanAvailable() {
        assertThrows(IllegalArgumentException.class,
                () -> examinerService.getRandomUniqueQuestions(3));
    }

    @Test
    void getQuestions_ReturnsAllQuestions() {
        Set<Question> questions = examinerService.getQuestions();
        assertThat(questions).hasSize(2);
        assertThat(questions).extracting(Question::getQuestion)
                .containsExactlyInAnyOrder("What is Java?", "What is JVM?");
    }
}