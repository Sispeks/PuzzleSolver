package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by felixhoffmann on 26.03.17.
 */
public class Dictionary {
    private String languageLong;
    private String languageShort;
    private HashMap<String,Integer> wordList;
    private final boolean substituteSpecialCharacters = true;
    //constructors
    public Dictionary() {

    }

    //getters and setters
    public String getLanguageLong() {return this.languageLong;}
    public void setLanguageLong(String languageLong) {this.languageLong = languageLong;}

    public String getLanguageShort() {return this.languageShort;}
    public void setLanguageShort(String languageShort) {this.languageShort = languageShort;}

    public HashMap<String,Integer> getWordList(){return this.wordList;}
    public void setWordList(HashMap<String,Integer> wordList) {this.wordList = wordList;}

    // real methods
    public HashMap<String,Integer> getAllWordsOfLength(int n) {
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        for (String word : this.wordList.keySet()) {
           if (word.length() == n) {
               result.put(word,n);
           }
        }
        return result;
    }
    public void constructWordListFromCSV(File file) {
        try {
            if(file.exists()){
                String thisLine = null;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath().toString()));
                while ((thisLine = bufferedReader.readLine()) != null) {
                    this.wordList.put(thisLine,thisLine.length());
                }
            }

        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
