package bip.online.coursework2.service;

import bip.online.coursework2.entity.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class JavaQuestionsServiceTest {
    @InjectMocks
    JavaQuestionsService service;
    Question question, question2;

    @BeforeEach
    public void initOut() {
        question = new Question("1", "1");
        question2 = new Question("2", "2");
    }


    @Test
    void testAddObject() {
        Assertions.assertEquals(service.add(question), question);
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(service.add("1", "1"), question);
    }

    @Test
    void remove() {
        service.add(question);
        Assertions.assertEquals(service.remove(question), question);
    }

    @Test
    void getAll() {
        service.add("1", "1");
        service.add("2", "2");
        List<Question> questions = List.of(question, question2);
        Assertions.assertEquals(service.getAll(), questions);
    }

    @Test
    void getRandomQuestion() {
        Assertions.assertNull(service.getRandomQuestion());
    }
}