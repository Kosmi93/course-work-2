package bip.online.coursework2.controller;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.service.ExaminerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {
    private final ExaminerService service;

    @GetMapping
    public Collection<Question> getQuestions(int amount) {
        return service.getQuestions(amount);
    }
}
