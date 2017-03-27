package models;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by felixhoffmann on 27.03.17.
 */
public class Dictionary {
    private String languageLong;
    private String languageShort;
    private HashMap<String,Integer> wordList;
    private final boolean substituteSpecialCharacters;
    //constructors
    public Dictionary(String filename) {
        this.substituteSpecialCharacters = true;
    }

    //getters and setters
    public String getLanguageLong() {return this.languageLong;}
    public void setLanguageLong(String languageLong) {this.languageLong = languageLong;}

    public String getLanguageShort() {return this.languageShort;}
    public void setLanguageShort(String languageShort) {this.languageShort = languageShort;}

    public HashMap<String,Integer> getWordList(){return this.wordList;}
    public void setWordList(HashMap<String,Integer>) {this.wordList = wordList;}

    // real methods
    public HashMap<String,Integer> getAllWordsOfLength(Integer n) {
        HashMap<String,Integer> result = new HashMap<String, Integer>(this.wordList);
        Collection<Integer> c = result.values();
        c.remove(n);
        System.out.println(c.toString());
        result.values().removeAll(c);
        return result;
    }
}
