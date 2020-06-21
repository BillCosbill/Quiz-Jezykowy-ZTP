package model.question;

import model.Word;

public abstract class Question {
    protected Word correctAnswer;
    protected boolean englishToPolish;

    public Question(Word correctWord, boolean englishToPolish) {
        this.correctAnswer = correctWord;
        this.englishToPolish = englishToPolish;
    }

    public String getQuestionText() {
        return !englishToPolish ? this.correctAnswer.getEnglishWord() : this.correctAnswer.getPolishWord();
    }

    public String getCorrectAnswer() {
        return correctAnswer.getAppropriateWord(englishToPolish);
    }

    public Word getCorrectWord() {
        return correctAnswer;
    }
}

