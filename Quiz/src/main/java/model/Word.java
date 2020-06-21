package model;

public class Word {
    private String englishWord;
    private String polishWord;

    public Word(String englishWord, String polishWord) {
        this.englishWord = englishWord;
        this.polishWord = polishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getPolishWord() {
        return polishWord;
    }

    public void setPolishWord(String polishWord) {
        this.polishWord = polishWord;
    }

    public String getAppropriateWord(boolean english) {
        return english ? englishWord : polishWord;
    }

    @Override
    public String toString() {
        return englishWord + "=" + polishWord;
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        return this.englishWord.equals(((Word) obj).englishWord);
    }

    @Override
    public int hashCode() {
        int result;
        result = englishWord.hashCode() / 11;
        return result;
    }
}
