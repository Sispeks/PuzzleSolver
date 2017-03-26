package models;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by felixhoffmann on 26.03.17.
 */
public class Word {
    private String hint; // the puzzle hint of the word
    private String identifier; // something like 1 across or 1 waagrecht
    private int length; // length of the word to find
    private int[] position; // position in the cross word puzzle
    private String solution; // the word itself.
    private HashMap<Integer,Character> constraints; // the known letters for the word.
    //constructors
    public Word() {}


    //getter and setter methods
    public String getHint() { return this.hint;}
    public void setHint(String hint) {this.hint = hint;}

    public String getIdentifier() {return this.identifier;}
    public void setIdentifier(String identifier) {this.identifier = identifier;}

    public int getLength() {return this.length;}
    public void setLength(int length) {this.length = length;}

    public int[] getPosition() {return this.position;}
    public void setPosition(int[] position) {this.position = position;}

    public String getSolution() {return this.solution;}
    public void setSolution(String solution) {this.solution = solution;}

    //real methods

    /**
     * Taking a set of dictionaries, this method looks up all possible words based on the constraints to the word.
     * @return
     */
    public Set<Word> getSolutions() {

    }
}
