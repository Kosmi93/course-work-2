package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service

public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionsService javaService;
    private final QuestionsService mathService;

    public ExaminerServiceImpl(@Qualifier("JavaQuestionsService") QuestionsService service,
                               @Qualifier("MathQuestionsService") QuestionsService mathService) {
        this.javaService = service;
        this.mathService = mathService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> listRandomQuestions = new HashSet<>();
        Random random = new Random();
        while (listRandomQuestions.size() < amount) {
            if (random.nextInt(100) < 50)
                listRandomQuestions.add(javaService.getRandomQuestion());
            else listRandomQuestions.add(mathService.getRandomQuestion());
        }
        return listRandomQuestions;
    }
}
