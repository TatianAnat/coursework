package org.skypro.question;

import java.util.List;

/**
 * контроллер для REST API
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        return questionService.getRandomQuestions(amount);
    }

    @PostMapping("/java/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/java/remove/{id}")
    public ResponseEntity<Void> removeQuestion(@PathVariable long id) {
        boolean removed = questionService.removeQuestion(id);
        if(removed) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/java/find")
    public List<Question> findAll() {
        return questionService.findQuestions();
    }
}
