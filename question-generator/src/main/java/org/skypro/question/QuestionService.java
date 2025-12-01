package org.skypro.question;

import java.util.Set;

/**
 * Интерфейс сервиса по работе с вопросами
 */
public interface QuestionService {
    void addQuestion(Question question);
    boolean removeQuestion(Question question);
    Set<Question> findAllQuestions();
    Question getRandomQuestion();
}