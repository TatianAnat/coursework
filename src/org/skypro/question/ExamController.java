package org.skypro.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

public class ExamController {

    private final ExaminerServiceImpl examinerService;

    @Autowired
    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        /**
         * Возвращаем уникальные случайные вопросы в запрошенном количестве
          */
        return examinerService.getRandomUniqueQuestions(amount);
    }
}
