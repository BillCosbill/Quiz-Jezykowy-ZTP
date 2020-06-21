package model.proxy;

import model.Word;

import java.util.Iterator;
import java.util.List;

public interface Dictionary {

    List<Word> getWordList();

    Word getRandomWord();

    Word[] getRandomWords(int wordsNumber);

    Iterator<Word> iterator();

}
