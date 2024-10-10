package model;

// Represents an accomplishment with a name and date
public class Accomplishment {

    private String name;
    private String date;

    /*
     * REQUIRES: name and date have a non-zero length
     * EFFECTS: constructs an accomplishment with a given name and date
     */
    public Accomplishment(String name, String date) {
        this.name = name;
        this.date = date;
    }

    /*
     * REQUIRES: name input has a non-zero length
     * EFFECTS: changes name of the accomplishment 
     */
    public void changeName(String name) {
        this.name = name;
    }

    /*
     * REQUIRES: date input has a non-zero length
     * EFFECTS: changes date of the accomplishment 
     */
    public void changeDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
