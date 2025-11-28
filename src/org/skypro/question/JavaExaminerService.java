package org.skypro.question;

import java.util.Set;

public class JavaExaminerService implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public JavaExaminerService(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Set<Question> getQuestions() {
        return javaQuestionService.findAllQuestions();
    }
}
