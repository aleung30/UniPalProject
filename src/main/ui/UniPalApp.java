package ui;

import java.util.Scanner;

import model.Accomplishment;
import model.AccomplishmentCollection;
import model.Mood;
import model.MoodCollection;

// UniPal jounal application
public class UniPalApp {
    private MoodCollection myMoodCollection;
    private AccomplishmentCollection myAccomplishmentCollection;
    private Scanner input;

    // EFFECTS: run the UniPal application
    public UniPalApp() {
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
        } else {
            System.out.println("Invalid choice, please try again...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes mood and accomplishment collections
    private void initializeCollections() {
        myMoodCollection = new MoodCollection();
        myAccomplishmentCollection = new AccomplishmentCollection();
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
        myAccomplishmentCollection.addAccomplishment(newAccomplishment);

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
        myMoodCollection.addMood(newMood);

        System.out.println("You have successfully added: " + newMood.getName() + ", " + newMood.getType() + ", "
                + newMood.getDate());
    }

    // EFFECTS: prints out all accomplishments in the accomplishment collection and prints empty for empty collection
    private void doViewAccomplishmentCollection() {
        System.out.println("Presenting all of your accomplishments:");
        if (myAccomplishmentCollection.getAccomplishmentCollection().isEmpty()) {
            System.out.println("This list is empty, please add an accomplishment to your collection before checking");
        } else {
            for (Accomplishment accomplishment : myAccomplishmentCollection.getAccomplishmentCollection()) {
                System.out.println("\tAccomplishment: " + accomplishment.getName() + ", " + accomplishment.getDate());
            }
        }
    }

    // EFFECTS: prints out all moods in the mood collection and prints empty for empty collection
    private void doViewMoodCollection() {
        System.out.println("Presenting all of your moods:");
        if (myMoodCollection.getMoodCollection().isEmpty()) {
            System.out.println("This list is empty, please add an accomplishment to your collection before checking");
        } else {
            for (Mood mood : myMoodCollection.getMoodCollection()) {
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

        boolean moodExists = myMoodCollection.containsMoodName(moodName);
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

        String recommendations = myMoodCollection.getRecommendation(newMood);

        System.out.println("Here are your recommended relaxation methods based on your mood type:" + recommendations);
    }
}
