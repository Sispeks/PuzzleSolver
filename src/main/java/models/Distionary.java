package models;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by felixhoffmann on 26.03.17.
 */
public class Distionary {
    private String languageLong;
    private String languageShort;
    private HashMap<String,Integer> wordList;
    private final boolean substituteSpecialCharacters;
    //constructors
    public Dictionary() {

    }

    //getters and setters
    public String getLanguageLong() {return this.languageLong;}
    public void setLanguageLong(String languageLong) {this.languageLong = languageLong;}

    public String getLanguageShort() {return this.languageShort;}
    public void setLanguageShort(String languageShort) {this.languageShort = languageShort;}

    public HashMap<String,Integer> getWordList(){return this.wordList;}
    public void setWordList(HashMap<String,Integer>) {this.wordList = wordList;}

    // real methods
    public HashMap<String,Integer> getAllWordsOfLength(int n) {
        Collection<Integer> c = this.wordList.values();
        c.remove(n);
        return this.wordList.values().removeAll(c);
    }
}
