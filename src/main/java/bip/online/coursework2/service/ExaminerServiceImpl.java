package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.exception.IndexOfException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionsService service;

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> listRandomQuestions = new HashSet<>();
        int size = service.getAll().size();
        if (amount > size) {
            throw new IndexOfException("Количество запрашиваемых вопросов больше чем имеется в базе.");
        } else if (amount == size)
            return service.getAll();

        while (listRandomQuestions.size() < amount) {
            listRandomQuestions.add(service.getRandomQuestion());
        }
        return listRandomQuestions;
    }
}
