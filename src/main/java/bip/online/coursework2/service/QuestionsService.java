package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;

import java.util.Collection;

public interface QuestionsService {
    Question add(Question question);

    Question add(String questions, String answer);

    Question remove(Question question);

    public Collection<Question> getAll();

    Question getRandomQuestion();
}
