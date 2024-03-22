package bip.online.coursework2.controller;

import bip.online.coursework2.service.QuestionsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/math")

public class MathQuestionsController {


    private final QuestionsService service;

    public MathQuestionsController(@Qualifier("MathQuestionsService")QuestionsService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public ResponseEntity addQuestion(String question, String answer) {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping
    public ResponseEntity getQuestions() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping("/remove")
    public ResponseEntity removeQuestion(String question, String answer) {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
