package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question>getQuestions(int amount);
}
