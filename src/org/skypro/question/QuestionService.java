package org.skypro.question;

import java.util.List;

/**
 * Интерфейс сервиса по работе с вопросами
 */
public interface QuestionService {
    void addQuestion(Question question);
    boolean removeQuestion(Question question);
    List<Question> findAllQuestions();
    Question getRandomQuestion();
}