package models;

import java.util.HashMap;

/**
 * Created by felixhoffmann on 26.03.17.
 */
public class Puzzle {
    private HashMap<Integer,String> words;
    private String finalSolution;

    public Puzzle() {
        this.words = new HashMap<Integer, String>();
        this.finalSolution = "";
    }


}
