package bip.online.coursework2.repo;

import bip.online.coursework2.entity.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MathQuestionsRepo implements QuestionRepository{

    private final List<Question> questions = new ArrayList<>();

    @PostConstruct
    private void initRepo(){
        questions.addAll(List.of(
           new Question("Сколько миллиметров в одном литре?","Всего в одном литре 1000 миллиметров."),
           new Question("Какой день является числом Пи?","14 марта"),
           new Question("Кто является отцом математики?","Архимед"),
           new Question("Кто этот ученый, родившийся в день числа Пи?","Альберт Эйнштейн")
        ));
    }

    @Override
    public List<Question> findAll() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question save(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question delete(Question question) {
        questions.remove(question);
        return question;
    }
}
