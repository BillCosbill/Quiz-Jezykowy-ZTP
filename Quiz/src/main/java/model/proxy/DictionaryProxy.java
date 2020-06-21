package model.proxy;

import model.Word;
import model.progress.Level;
import model.proxy.Dictionary;
import model.proxy.DictionaryOrginal;

import java.util.Iterator;
import java.util.List;

public class DictionaryProxy implements Dictionary {
    DictionaryOrginal dictionary;
    Level level;

    public DictionaryProxy(Level level){
        this.level = level;
    }

    @Override
    public List<Word> getWordList() {
        if (this.dictionary == null) this.dictionary = new DictionaryOrginal (this.level);
        return dictionary.getWordList();
    }


    public Level getLevel() {
        return level;
    }

    @Override
    public Word getRandomWord() {
        if (this.dictionary == null) this.dictionary = new DictionaryOrginal (this.level);
        return dictionary.getRandomWord();
    }

    @Override
    public Word[] getRandomWords(int wordsNumber) {
        if (this.dictionary == null) this.dictionary = new DictionaryOrginal (this.level);
        return dictionary.getRandomWords(wordsNumber);
    }

    @Override
    public Iterator<Word> iterator(){
        if (this.dictionary == null) this.dictionary = new DictionaryOrginal (this.level);
        return dictionary.iterator();
    }
}
