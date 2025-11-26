package org.skypro.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * сервис для работы с вопросами
 */
@Service
public class QuestionService {
    private  final Map<Long, Question> questions = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Question> getRandomQuestions(int amount) {
        Collections.shuffle(list);
        return list.stream().limit(amount).collect(Collectors.toList());
    }

    public Question addQuestion(Question q) {
        long id = idGenerator.incrementAndGet();
        q.setId(id);
        questions.put(id,q);
        return  q;
    }

    public boolean removeQuestion(Long id) {
        return questions.remove(id) != null;
    }

    public List<Question> findQuestions() {
        return  new ArrayList<>(questions.values());
    }
}
