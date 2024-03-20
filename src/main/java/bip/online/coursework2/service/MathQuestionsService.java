package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.repo.MathQuestionsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service(value = "MathQuestionsService")
@RequiredArgsConstructor
public class MathQuestionsService implements QuestionsService {

    private final MathQuestionsRepo repository;

    @Override
    public Question add(Question question) {
        return repository.save(question);
    }

    @Override
    public Question add(String questions, String answer) {
        Question question = new Question(questions, answer);
        return repository.save(question);
    }

    @Override
    public Question remove(Question question) {
        repository.delete(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.findAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        List<Question> temp = repository.findAll();
        if(temp.isEmpty())
            return null;
        else
            return temp.get(r.nextInt(temp.size()));
    }
}
