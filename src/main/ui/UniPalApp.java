package ui;

import java.util.Scanner;

import model.Accomplishment;
import model.Mood;

import model.UniPalBoard;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

// UniPal jounal application
public class UniPalApp {
    private static final String JSON_STORE = "./data/unipalboard.json";
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private UniPalBoard uniPal;

    // EFFECTS: run the UniPal application
    public UniPalApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        uniPal = new UniPalBoard("Anita's workroom");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runUniPal();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runUniPal() {
        boolean continueProcess = true;
        String command = null;

        initializeCollections();

        while (continueProcess) {
            showMenuChoices();
            command = input.next();

            if (command.equals("q")) {
                continueProcess = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("You have quit the application!");
    }

    // EFFECTS: lists different menu choices for user
    private void showMenuChoices() {
        System.out.println("\nChoose from one of the following:");
        System.out.println("\taa -> add an accomplishment");
        System.out.println("\tam -> add a mood");
        System.out.println("\tva -> view my accomplishment collection");
        System.out.println("\tvm -> view my mood collection");
        System.out.println("\tcm -> check if mood name is in the MoodCollection");
        System.out.println("\trm -> receive relaxation method suggestions");
        System.out.println("\ts -> save UniPalBoard to file");
        System.out.println("\tl -> load UniPalBoard from file");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("aa")) {
            doAddAccomplishment();
        } else if (command.equals("am")) {
            doAddMood();
        } else if (command.equals("va")) {
            doViewAccomplishmentCollection();
        } else if (command.equals("vm")) {
            doViewMoodCollection();
        } else if (command.equals("cm")) {
            doCheckForMoodName();
        } else if (command.equals("rm")) {
            doSuggestRelaxationMethods();
        } else if (command.equals("s")) {
            saveUniPalBoard();
        } else if (command.equals("l")) {
            loadUniPalBoard();
        } else {
            System.out.println("Invalid choice, please try again...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes mood and accomplishment collections
    private void initializeCollections() {
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
    }

    // MODIFIES: this
    // EFFECTS: conducts adding an accomplishment to the collection
    private void doAddAccomplishment() {
        String accomplishmentName;
        String accomplishmentDate;

        System.out.println("Please enter what accomplishment you would like to add to this collection!");

        System.out.println("Add accomplishment name: ");
        accomplishmentName = input.next();

        System.out.println("Add accomplishment date: ");
        accomplishmentDate = input.next();

        Accomplishment newAccomplishment = new Accomplishment(accomplishmentName, accomplishmentDate);
        uniPal.addAccomplishment(newAccomplishment);

        System.out.println(
                "You have successfully added: " + newAccomplishment.getName() + ", " + newAccomplishment.getDate());
    }

    // MODIFIES: this
    // EFFECTS: conducts adding a mood to the collection
    private void doAddMood() {
        String moodName;
        String moodType;
        String moodDate;

        System.out.println("Please enter what mood you would like to add to this collection!");

        System.out.print("Add mood name: ");
        moodName = input.next();

        System.out.print("Add mood type (must be - POSITIVE, NEUTRAL, or NEGATIVE): ");
        moodType = input.next();

        System.out.print("Add mood date: ");
        moodDate = input.next();

        Mood newMood = new Mood(moodName, moodType, moodDate);
        uniPal.addMood(newMood);

        System.out.println("You have successfully added: " + newMood.getName() + ", " + newMood.getType() + ", "
                + newMood.getDate());
    }

    // EFFECTS: prints out all accomplishments in the accomplishment collection and
    // prints empty for empty collection
    private void doViewAccomplishmentCollection() {
        System.out.println("Presenting all of your accomplishments:");
        if (uniPal.getAccomplishmentCollection().isEmpty()) {
            System.out.println("This list is empty, please add an accomplishment to your collection before checking");
        } else {
            for (Accomplishment accomplishment : uniPal.getAccomplishmentCollection()) {
                System.out.println("\tAccomplishment: " + accomplishment.getName() + ", " + accomplishment.getDate());
            }
        }
    }

    // EFFECTS: prints out all moods in the mood collection and prints empty for
    // empty collection
    private void doViewMoodCollection() {
        System.out.println("Presenting all of your moods:");
        if (uniPal.getMoodCollection().isEmpty()) {
            System.out.println("This list is empty, please add a mood to your collection before checking");
        } else {
            for (Mood mood : uniPal.getMoodCollection()) {
                System.out
                        .println("\tMood: " + mood.getName() + " Type: " + mood.getType() + " Date: " + mood.getDate());
            }
        }
    }

    // EFFECTS: conducts checking for mood name
    private void doCheckForMoodName() {
        String moodName;
        System.out.println("Please enter the name of the mood you would like to check!");

        System.out.println("Enter mood name: ");
        moodName = input.next();

        boolean moodExists = uniPal.containsMoodName(moodName);
        if (moodExists == true) {
            System.out.println("It is " + moodExists + ", your collection does contain this mood name!");
        } else {
            System.out.println("It is " + moodExists + ", your collection does not contain this mood name!");
        }
    }

    // EFFECTS: conducts suggesting relaxation methods
    private void doSuggestRelaxationMethods() {
        String moodName;
        String moodType;
        String moodDate;

        System.out.println("Please enter the mood you would like to get relaxation methods for!");

        System.out.print("Add mood name: ");
        moodName = input.next();

        System.out.print("Add mood type (must be - POSITIVE, NEUTRAL, or NEGATIVE): ");
        moodType = input.next();

        System.out.print("Add mood date: ");
        moodDate = input.next();

        Mood newMood = new Mood(moodName, moodType, moodDate);

        String recommendations = uniPal.getRecommendation(newMood);

        System.out.println("Here are your recommended relaxation methods based on your mood type:" + recommendations);
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: saves the UniPalBoard to file
    public void saveUniPalBoard() {
        try {
            jsonWriter.open();
            jsonWriter.write(uniPal);
            jsonWriter.close();
            System.out.println("Saved " + uniPal.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads UniPalBoard from file
    private void loadUniPalBoard() {
        try {
            uniPal = jsonReader.read();
            System.out.println("Loaded " + uniPal.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
