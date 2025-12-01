package org.skypro.question.config;

import org.skypro.question.JavaQuestionService;
import org.skypro.question.QuestionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public QuestionService questionService() {
        return new JavaQuestionService();
    }
}
