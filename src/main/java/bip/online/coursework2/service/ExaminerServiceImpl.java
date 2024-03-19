package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.exception.IndexOfException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

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
        int javaSize = javaService.getAll().size();
        int mathSize = mathService.getAll().size();
        Random random = new Random();
        if (amount > javaSize + mathSize) {
            throw new IndexOfException("Количество запрашиваемых вопросов больше чем имеется в базе.");
        } else if (amount == javaSize+mathSize){
            List<Question> temp = new ArrayList<>();
            temp.addAll(javaService.getAll());
            temp.addAll(mathService.getAll());
            return temp;
        } //выбрать случайно вопросы из ...
        while (listRandomQuestions.size() < amount) {
            if(random.nextInt(100)<50)
                listRandomQuestions.add(javaService.getRandomQuestion());
            else listRandomQuestions.add(mathService.getRandomQuestion());
        }
        return listRandomQuestions;
    }
}
