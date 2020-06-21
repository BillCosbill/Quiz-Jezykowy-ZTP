package model.quiz;

import model.proxy.DictionaryProxy;
import model.builder.LearnQuizBuilder;
import model.progress.Progress;

public class LearnQuiz extends Quiz {
    public LearnQuiz(DictionaryProxy dictionaryProxy, int questionsCount) {
        super(dictionaryProxy);

        LearnQuizBuilder learnQuizBuilder = new LearnQuizBuilder(this.dictionaryProxy, Progress.getInstance());
        learnQuizBuilder.createQuestions();
        this.questions = learnQuizBuilder.getQuestions();
    }
}
