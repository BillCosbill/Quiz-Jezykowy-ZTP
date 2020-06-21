package model.builder;

import model.proxy.DictionaryProxy;
import model.question.ClosedQuestion;
import model.question.OpenedQuestion;
import model.question.Question;

import java.util.Random;

public class TestQuizBuilder extends QuizBuilder {

    public TestQuizBuilder(DictionaryProxy dictionaryProxy) {
        super(dictionaryProxy);
    }

    @Override
    public void createQuestions() {
        int questionCount = 10;
        for (int i = 0; i < questionCount; i++) {
            createQuestion();
        }
    }

    @Override
    public void createQuestion() {
        Question question;
        Random random = new Random();
        boolean englishOrPolish = random.nextBoolean();
        boolean openedOrClosed = random.nextBoolean();
        if (openedOrClosed) {
            question = new OpenedQuestion(dictionaryProxy.getRandomWord(), englishOrPolish);
        } else {
            question = new ClosedQuestion(dictionaryProxy.getRandomWord(), dictionaryProxy.getRandomWords(3), englishOrPolish);
        }
        questions.add(question);
    }

}
