package persistence;

import model.UniPalBoard;

import java.io.IOException;

import org.json.*;

// Represents a reader that reads unipalboard from JSON data stored in file
public class JsonReader {

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {

    }

    // EFFECTS: reads moodcollection from file and returns it;
    public UniPalBoard read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null;

    }

    // EFFECTS: parses UniPalBoard from JSON object and returns it
    private UniPalBoard parseUniPalBoard(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: account
    // EFFECTS: parses mood collection from JSON object and adds them to unipalboard
    private void addMoodCollection(UniPalBoard up, JSONObject jsonObject) {

    }

    // MODIFIES: account
    // EFFECTS: parses accomplishment from JSON object and adds them to unipalboard
    private void addAccomplishment(UniPalBoard up, JSONObject jsonObject) {

    }

    // MODIFIES: account
    // EFFECTS: parses accomplishment collection from JSON object and adds them to
    // unipalboard
    private void addAccomplishmentCollection(UniPalBoard up, JSONObject jsonObject) {

    }

    // MODIFIES: account
    // EFFECTS: parses mood from JSON object and adds them to unipalboard
    private void addMood(UniPalBoard up, JSONObject jsonObject) {

    }

}
