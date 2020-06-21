package model.quiz;

import model.proxy.DictionaryProxy;
import model.question.Question;

import java.util.LinkedList;

public abstract class Quiz {
    protected LinkedList<Question> questions;
    protected DictionaryProxy dictionaryProxy;
    protected int currentQuestionNumber;

    public Quiz(DictionaryProxy dictionaryProxy) {
        this.dictionaryProxy = dictionaryProxy;
        currentQuestionNumber = 0;
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public LinkedList<Question> getQuestions() {
        return questions;
    }

    public DictionaryProxy getDictionaryProxy() {
        return dictionaryProxy;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionNumber);
    }

    public void nextQuestion() {
        currentQuestionNumber++;
    }
}
