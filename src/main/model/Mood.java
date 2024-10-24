package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a mood with a name, a type, and date
public class Mood implements Writable {
    private String name;
    private String type;
    private String date;

    /*
     * REQUIRES: name has a non-zero length; date has a non-zero length;
     * type is one of "POSITIVE", "NEUTRAL", or "NEGATIVE"
     * EFFECTS: constructs a Mood object with a name, type, and date
     */
    public Mood(String name, String type, String date) {
        this.name = name;
        this.type = type;
        this.date = date;
    }

    /*
     * REQUIRES: name has a non-zero length
     * MODIFIES: this
     * EFFECTS: changes name of Mood object
     */
    public void changeName(String name) {
        this.name = name;
    }

    /*
     * REQUIRES: type is a valid type; type has a non-zero length
     * MODIFIES: this
     * EFFECTS: changes type of Mood object
     */
    public void changeType(String type) {
        this.type = type;
    }

    /*
     * REQUIRES: date has a non-zero length
     * MODIFIES: this
     * EFFECTS: changes date of Mood object
     */
    public void changeDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("type", type);
        json.put("date", date);
        return json;
    }
}
