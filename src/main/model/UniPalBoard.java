package model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

//Represents a UniPalBoard
public class UniPalBoard implements Writable {
    private MoodCollection moodCollection;
    private AccomplishmentCollection accomplishmentCollection;
    private String name;

    /*
     * EFFECTS: constructs an UniPalBoard with a name, MoodCollection, and
     * AccomplishmentCollection
     */
    public UniPalBoard(String name) {
        this.name = name;
        this.moodCollection = new MoodCollection();
        this.accomplishmentCollection = new AccomplishmentCollection();
    }

    public String getName() {
        return name;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds a Mood to the MoodCollection
     */
    public void addMood(Mood mood) {
        this.moodCollection.addMood(mood);
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an accomplishment to the AccomplishmentCollection
     */
    public void addAccomplishment(Accomplishment accomplishment) {
        accomplishmentCollection.addAccomplishment(accomplishment);
    }

    /*
     * EFFECTS: returns the MoodCollection
     */
    public ArrayList<Mood> getMoodCollection() {
        return moodCollection.getMoodCollection();
    }

    /*
     * EFFECTS: returns the AccomplishmentCollection
     */
    public ArrayList<Accomplishment> getAccomplishmentCollection() {
        return accomplishmentCollection.getAccomplishmentCollection();
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
     * EFFECTS: returns true if name matches the name of a mood in the collection;
     * return false if name does not match any
     */
    public boolean containsMoodName(String name) {
        for (Mood m : moodCollection.getMoodCollection()) {
            if (m.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("moodCollection", moodCollectionToJson());
        json.put("accomplishmentCollection", accomplishmentCollectionToJson());
        return json;
    }

    // EFFECTS: returns things in this unipalboard as a JSON array
    private JSONArray moodCollectionToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Mood mood : moodCollection.getMoodCollection()) {
            jsonArray.put(mood.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns things in this unipalboard as a JSON array
    private JSONArray accomplishmentCollectionToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Accomplishment accomplishment : accomplishmentCollection.getAccomplishmentCollection()) {
            jsonArray.put(accomplishment.toJson());
        }

        return jsonArray;
    }
}
