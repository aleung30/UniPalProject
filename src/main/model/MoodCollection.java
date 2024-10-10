package model;

import java.util.ArrayList;
import java.util.List;

// Represents a collection of Mood objects
public class MoodCollection {
    private List<Mood> moodCollection;

    /*
     * EFFECTS: constructs an empty list to store Mood objects
     */
    public MoodCollection() {
        moodCollection = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds a Mood to the MoodCollection
     */
    public void addMood(Mood mood) {
        this.moodCollection.add(mood);
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes a Mood from the MoodCollection
     */
    public void removeMood(Mood mood) {
        this.moodCollection.remove(mood);
    }

    /*
     * EFFECTS: returns true if name matches the name of a mood in the collection
     * return false if name does not match any
     */
    public boolean containsMoodName(String name) {
        for (Mood m : moodCollection) {
            if (m.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*
     * EFFECTS: returns true if type name matches the type name of a mood in the
     * collection
     * return false if name does not match any
     */
    public boolean containsMoodType(String type) {
        for (Mood m : moodCollection) {
            if (m.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    /*
     * REQUIRES: MoodCollection is not an empty list
     * EFFECTS: returns all the moods in the list that match the type name
     * and creates a new list with them
     */

    public MoodCollection sortMoodsByTypeName(String type) {
        MoodCollection specificMoodCollection = new MoodCollection();
        for (Mood m : moodCollection) {
            if (m.getType().equals(type)) {
                specificMoodCollection.addMood(m);
            }
        }
        return specificMoodCollection;
    }

    /*
     * REQUIRES: Mood object has a valid type
     * EFFECTS: returns a recommendation based on mood type name
     */
    public String getRecommendation(Mood mood) {
        String moodType = mood.getType();
        if ("POSITIVE".equals(moodType)) {
            return "That is great to hear!"
                    + " Keep up the positive vibes with meditation, a light walk, or listening to upbeat songs!";
        } else if ("NEUTRAL".equals(moodType)) {
            return "Feeling neutral is a great way to reflect on yourself!"
                    + " You can engage in gentle stretching, read a book and journal, or watch a relaxing movie!";
        } else {
            return "It sounds like you are experiencing some overwhelming emotions!"
                    + " How about some deep breathing exercises or spending time with friends and family?";
        }
    }

    /*
     * REQUIRES: getMoods has at least one item in the list
     * EFFECTS: returns the number of Mood objects in the moods list
     */
    public int moodSize() {
        return moodCollection.size();
    }
}
