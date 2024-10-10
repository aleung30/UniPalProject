package model;

// Represents a collection of Accomplishment objects
public class AccomplishmentCollection {

    /*
     * EFFECTS: constructs an empty list that stores Accomplishment objects
     */

    public AccomplishmentCollection() {

    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an accomplishment to the AccomplishmentCollection
     */
    public void addAccomplishment(Accomplishment accomplishment) {

    }

    /*
     * MODIFIES: this
     * EFFECTS: removes an accomplishment from the AccomplishmentCollection
     */
    public void removeAccomplishment(Accomplishment accomplishment) {

    }

    /*
     * REQUIRES: AccomplishmentCollection is not an empty list
     * EFFECTS: returns true if name matches the name of an accomplishment in the
     *          collection and returns false if it does not match
     */
    public boolean containsAccomplishment(String name) {
        return true;
    }

    /*
     * EFFECTS: returns the number of Accomplishment objects in the
     *          AccomplishmentCollection
     */
    public int accomplishmentSize() {
        return 0;
    }

}
