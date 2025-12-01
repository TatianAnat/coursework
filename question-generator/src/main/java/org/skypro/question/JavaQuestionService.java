package org.skypro.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * реализация QuestionService для вопросов Java
 */
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public boolean removeQuestion(Question question) {
        return questions.remove(question);
    }

    @Override
    public Set<Question> findAllQuestions() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}
