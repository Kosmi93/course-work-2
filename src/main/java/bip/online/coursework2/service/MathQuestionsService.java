package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service(value = "MathQuestionsService")
@RequiredArgsConstructor
public class MathQuestionsService implements QuestionsService {
    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question add(String questions, String answer) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {

        Random r = new Random();
        int i = r.nextInt(1, 100);
        return new Question("Вопрос №" + i, "Ответ №" + i);

    }


}
