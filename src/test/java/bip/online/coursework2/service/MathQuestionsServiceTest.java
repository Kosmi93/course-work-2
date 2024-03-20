package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import bip.online.coursework2.repo.MathQuestionsRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MathQuestionsServiceTest {
    private final Question question = new Question("Вопрос", "Ответ");
    private final Question question2 = new Question("Вопрос2", "Ответ2");
    @Mock
    MathQuestionsRepo repo;

    private MathQuestionsService service;

    @BeforeEach
    public void setUp() {
        service = new MathQuestionsService(repo);
    }

    @Test
    void addObject() {
        Mockito.when(repo.save(question)).thenReturn(question);
        assertEquals(question, service.add(question));
    }

    @Test
    void testParam() {
        Mockito.when(repo.save(question)).thenReturn(question);
        assertEquals(question, service.add("Вопрос", "Ответ"));
    }

    @Test
    void remove() {
        Mockito.when(repo.delete(question)).thenReturn(question);
        assertEquals(question, service.remove(question));
    }

    @Test
    void getAll() {
        Mockito.when(repo.findAll()).thenReturn(List.of(question, question2));
        List<Question> questions = List.of(question, question2);
        assertIterableEquals(questions, service.getAll());
    }

    @Test
    void getRandomQuestionNull() {
        Assertions.assertNull(service.getRandomQuestion());
    }

    @Test
    void getRandomQuestion() {
        Mockito.when(repo.findAll()).thenReturn(List.of(question));
        assertEquals(question, service.getRandomQuestion());
    }
}