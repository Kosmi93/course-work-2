package bip.online.coursework2.controller;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
@RequiredArgsConstructor
public class JavaQuestionsController {

    private final QuestionsService service;

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
