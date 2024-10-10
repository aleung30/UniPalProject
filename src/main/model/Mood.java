package model;

// Represents a mood with a name, a type, and date
public class Mood {

    /*
     * REQUIRES: name has a non-zero length, string has a non-zero length
     *           type is a valid type (POSITIVE, NEUTRAL, OR NEGATIVE)
     * EFFECTS: constructs a Mood object with a name, type, and date
     * 
     */
    public Mood(String name, String type, String date) {

    }

    /*
     * REQUIRES: name has a non-zero length
     * MODIFIES: this
     * EFFECTS: changes name of Mood object
     */
    public void changeName(String name) {

    }

    /*
     * REQUIRES: type is a valid type
     * MODIFIES: this
     * EFFECTS: changes type of Mood object
     */
    public void changeType(String type) {

    }

    /*
     * REQUIRES: date has a non-zero length
     * MODIFIES: this
     * EFFECTS: changes date of Mood object
     */
    public void changeDate(String date) {

    }

    public String getName() {
        return null;
    }

    public String getType() {
        return null;
    }

    public String getDate() {
        return null;
    }
}
