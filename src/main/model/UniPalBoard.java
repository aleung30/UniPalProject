package model;


import java.util.ArrayList;


//Represents a UniPalBoard
public class UniPalBoard {

    /*
     * EFFECTS: constructs an UniPalBoard with a name, MoodCollection, and
     * AccomplishmentCollection
     */
    public UniPalBoard(String name) {

    }

    public String getName() {
        return null;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds a Mood to the MoodCollection
     */
    public void addMood(Mood mood) {

    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an accomplishment to the AccomplishmentCollection
     */
    public void addAccomplishment(Accomplishment accomplishment) {

    }

    /*
     * EFFECTS: returns the MoodCollection
     */
    public ArrayList<Mood> getMoodCollection() {
        ArrayList<Mood> mood = new ArrayList<>();
        return mood;
    }

    /*
     * EFFECTS: returns the AccomplishmentCollection
     */
    public ArrayList<Accomplishment> getAccomplishmentCollection() {
        ArrayList<Accomplishment> accomplishment = new ArrayList<>();
        return accomplishment;
    }

    /*
     * REQUIRES: Mood object has a valid type
     * EFFECTS: returns a recommendation based on mood type name
     */
    public String getRecommendation(Mood mood) {
        return null;

    }

    /*
     * EFFECTS: returns true if name matches the name of a mood in the collection;
     * return false if name does not match any
     */
    public boolean containsMoodName(String name) {
        return false;
    }
}
