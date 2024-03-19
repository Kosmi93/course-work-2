package bip.online.coursework2.controller;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.service.QuestionsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")

public class MathQuestionsController {


    private final QuestionsService service;

    public MathQuestionsController(@Qualifier("MathQuestionsService")QuestionsService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(String question, String answer) {
        return service.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(String question, String answer) {
        return service.remove(new Question(question, answer));
    }
}
