package model;

import java.util.ArrayList;

// Represents a collection of Accomplishment objects
public class AccomplishmentCollection {
    private ArrayList<Accomplishment> accomplishmentCollection;

    /*
     * EFFECTS: constructs an empty list that stores Accomplishment objects
     */

    public AccomplishmentCollection() {
        this.accomplishmentCollection = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an accomplishment to the AccomplishmentCollection
     */
    public void addAccomplishment(Accomplishment accomplishment) {
        this.accomplishmentCollection.add(accomplishment);
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes an accomplishment from the AccomplishmentCollection
     */
    public void removeAccomplishment(Accomplishment accomplishment) {
        this.accomplishmentCollection.remove(accomplishment);
    }

    /*
     * REQUIRES: AccomplishmentCollection is not an empty list
     * EFFECTS: returns true if name matches the name of an accomplishment in the
     * collection; returns false if none match
     */
    public boolean containsAccomplishment(String name, String date) {
        for (Accomplishment accomplishment : accomplishmentCollection) {
            if (accomplishment.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*
     * EFFECTS: returns the number of Accomplishment objects in the
     * AccomplishmentCollection
     */
    public int accomplishmentSize() {
        return this.accomplishmentCollection.size();
    }

    /*
     * EFFECTS: returns the AccomplishmentCollection
     */
    public ArrayList<Accomplishment> getAccomplishmentCollection() {
        return accomplishmentCollection;
    }
}
