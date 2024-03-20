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
    private JavaQuestionsService javaQuestionsService;
    @Mock
    private MathQuestionsService mathQuestionsService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Question question = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Mockito.when(mathQuestionsService.getAll()).thenReturn(List.of(question2));
        Mockito.when(mathQuestionsService.getRandomQuestion()).thenReturn(question2);
        Mockito.when(javaQuestionsService.getAll()).thenReturn(List.of(question));
        Mockito.when(javaQuestionsService.getRandomQuestion()).thenReturn(question);
        Assertions.assertEquals(2, examinerService.getQuestions(2).size());
    }

    @Test
    void getQuestionsException() {
        Assertions.assertThrows(IndexOfException.class, () -> examinerService.getQuestions(1000));
    }


}