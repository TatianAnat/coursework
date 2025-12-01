package org.skypro.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * Возвращает уникальные случайные вопросы.
     * @param amount количество вопросов
     * @return множество уникальных вопросов
     * если amount больше, чем количество доступных вопросов
     */
    public Set<Question> getRandomUniqueQuestions(int amount) {
        int available = questionService.findAllQuestions().size();
        if (amount > available || amount <= 0) {
            throw new IllegalArgumentException(
                    "Requested" + amount +  "questions, but only" + available + "available");
        }

        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            Question q = questionService.getRandomQuestion();
            uniqueQuestions.add(q);
        }
        return uniqueQuestions;
    }

    /**
     * Реализация интерфейсного метода
     */
    @Override
    public Set<Question> getQuestions() {
        /**
         * В реализации интерфейса можно задать фиксированное количество, или перегрузить метод
         *  пример с возвратом всех вопросов
         */
        return new HashSet<>(questionService.findAllQuestions());
    }
}