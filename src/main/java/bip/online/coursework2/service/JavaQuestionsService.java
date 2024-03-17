package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JavaQuestionsService implements QuestionsService {

    private final List<Question> questions = new ArrayList<>();

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question add(String questions, String answer) {
        Question question = new Question(questions, answer);
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        this.questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        if(questions.isEmpty())
            return null;
        else
            return questions.get(r.nextInt(questions.size()));
    }
}
