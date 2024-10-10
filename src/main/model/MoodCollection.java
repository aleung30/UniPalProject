package model;

// Represents a collection of Mood objects
public class MoodCollection {

    /*
     * EFFECTS: constructs an empty list to store Mood objects
     */
    public MoodCollection() {

    }

    /*
     * MODIFIES: this
     * EFFECTS: adds a Mood to the MoodCollection
     * 
     * 
     */
    public void addMood(Mood mood) {

    }

    /*
     * MODIFIES: this
     * EFFECTS: removes a Mood from the MoodCollection
     * 
     * 
     */
    public void removeMood(Mood mood) {

    }

    /*
     * EFFECTS: returns true if name matches the name, type, and date of a mood in the collection
     */
    public boolean containsMood(String name, String type, String date) {
        return true;
    }

    /*
     * REQUIRES: MoodCollection is not an empty list
     * EFFECTS: returns all the moods in the list that match the type name
     */

    public MoodCollection sortMoodsByTypeName(String type) {
        return null;
    }

    /*
     * REQUIRES: getMoods has at least one item in the list
     * EFFECTS: returns the number of Mood objects in the moods list
     * 
     */
    public int moodSize() {
        return 0;
    }

}
