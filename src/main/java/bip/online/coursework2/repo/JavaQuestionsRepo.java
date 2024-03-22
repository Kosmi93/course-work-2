package bip.online.coursework2.repo;

import bip.online.coursework2.entity.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository(value = "JavaQuestionsRepo")
public class JavaQuestionsRepo implements QuestionRepository {

    private final List<Question> questions = new ArrayList<>();

    @PostConstruct
    private void initRepo() {
        questions.addAll(List.of(
                new Question("Примитиыные типы", "byte, short, int, long — содержат " +
                        "в себе какую-либо цифру.\n" +
                        "float и double — хранят в себе вещественное число (с плавающей точкой/дробное).\n" +
                        "boolean — хранит истина/ложь.\n" +
                        "char — хранит в себе число, но еще и содержит дополнительную «пометку», что это не совсем" +
                        " число, а номер символа из таблицы символов. Следовательно, отрицательным быть не должен."),
                new Question("Значение примитива", "то, что в нём хранится. В зависимости от типа это " +
                        "число, флаг (true/false) или символ"),
                new Question("Null", "Null представляет собой пустоту.\n" +
                        "\n" +
                        "Что-то вроде пустой ячейки памяти, которой инициализируют все поля объектных (ссылочных)" +
                        " типов данных, если им не задано конкретное значение.")
        ));
    }

    @Override
    public List<Question> findAll() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question save(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question delete(Question question) {
        questions.remove(question);
        return question;
    }
}
