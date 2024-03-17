package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.exception.IndexOfException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionsService questionsService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Question question = new Question("1", "1");
        Mockito.when(questionsService.getAll()).thenReturn(List.of(question));
        Mockito.when(questionsService.getRandomQuestion()).thenReturn(question);
        Assertions.assertEquals(examinerService.getQuestions(1), List.of(question));
    }

    @Test
    void getQuestionsException() {
        Assertions.assertThrows(IndexOfException.class, () -> examinerService.getQuestions(1000));
    }


}