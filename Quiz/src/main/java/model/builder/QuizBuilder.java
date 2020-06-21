package model.builder;

import model.proxy.DictionaryProxy;
import model.progress.Progress;
import model.question.Question;

import java.util.LinkedList;

abstract class QuizBuilder {
    protected LinkedList<Question> questions;
    protected DictionaryProxy dictionaryProxy;
    protected Progress progress;

    public QuizBuilder(DictionaryProxy dictionaryProxy) {
        this.questions = new LinkedList<>();
        this.dictionaryProxy = dictionaryProxy;
        this.progress = Progress.getInstance();
    }

    public abstract void createQuestions();

    public abstract void createQuestion();

    public LinkedList<Question> getQuestions() {
        return this.questions;
    }
}
