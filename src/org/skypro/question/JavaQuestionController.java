package org.skypro.question;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService questionService;

    @Autowired
    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * добавить вопрос
     */
    @GetMapping("/add")
    public String addQuestion(@RequestParam String question,
                              @RequestParam String answer) {
        Question q = new Question(question, answer);
        questionService.addQuestion(q);
        return "Question added successfully";
    }
    /**
     * удалить вопрос
     */
    @GetMapping("/remove")
    public String removeQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        Question q = new Question(question,answer);
        boolean removed = questionService.removeQuestion(q);
        if (removed) {
            return "Question removed successfully";
        } else {
            return "Question not found";
        }
    }
    /**
     * получить список всех вопросов
     */
    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.findAllQuestions();
    }
}
