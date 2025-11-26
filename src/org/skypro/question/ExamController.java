package org.skypro.question;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/exam")
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
