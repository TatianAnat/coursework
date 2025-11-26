package org.skypro.question;

import java.util.List;

public class JavaExaminerService implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public JavaExaminerService(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public List<Question> getQuestions() {
        return javaQuestionService.findAllQuestions();
    }
}
