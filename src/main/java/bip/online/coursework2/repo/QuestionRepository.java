package bip.online.coursework2.repo;

import bip.online.coursework2.entity.Question;

import java.util.List;

public interface QuestionRepository {
    public List<Question> findAll();

    public Question save(Question question);

    public Question delete(Question question);
}
