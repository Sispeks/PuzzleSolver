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

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by felixhoffmann on 27.03.17.

 */
public class Dictionary {
    private String languageLong;
    private String languageShort;
    private HashMap<String,Integer> wordList;

    private final boolean substituteSpecialCharacters = true;
    //constructors
    public Dictionary() {


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

    /**
     * This method takes in constraints on the word, by already knowing some letters and the length,
     * e.g. return all four letter words starting 'f' and ending with 'ck'
     * @param n
     * @return
     */
    public HashMap<String,Integer> getAllWordsContraint(HashMap<Integer,Character> constraints, int n) {
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        for (String word : this.wordList.keySet()) {
            if (word.length() == n ) {
                boolean matchingConstraints = true;
                char[] chars = word.toCharArray();
                for (Integer position : constraints.keySet()) {
                    if (chars[position] != constraints.get(position)) {
                        matchingConstraints = false;
                        continue;
                    }
                }
                if (matchingConstraints) {
                    result.put(word,n);
                }

            }
        }
        return result;
    }


    public HashMap<String,Integer> getAllWordsOfLength(Integer n) {
        HashMap<String,Integer> result = new HashMap<String, Integer>(this.wordList);
        Collection<Integer> c = result.values();
        c.remove(n);
        System.out.println(c.toString());
        result.values().removeAll(c);
        return result;
    }
    public HashMap<String,Integer> getAllWordsMatching(HashMap<Integer,Character> constraints, int n) {
        HashMap<String,Integer> smallerSet = this.getAllWordsOfLength(n);

        for (String possibleResult : smallerSet.keySet()) {
            boolean match = true;
            for (int place : constraints.keySet()) {
                if (possibleResult.charAt(place) != constraints.get(place)) {
                    match = false;
                }
            }
            if (!match) {
                smallerSet.remove(possibleResult);
            }
        }
        return smallerSet;
    }

}
