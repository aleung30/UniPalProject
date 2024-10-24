package persistence;

import model.UniPalBoard;
import model.Accomplishment;
import model.Mood;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads unipalboard from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads moodcollection from file and returns it;
    public UniPalBoard read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseUniPalBoard(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        
        return contentBuilder.toString();

    }

    // EFFECTS: parses unipalboard from JSON object and returns it
    private UniPalBoard parseUniPalBoard(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        UniPalBoard up = new UniPalBoard(name);
        addMoodCollection(up, jsonObject);
        addAccomplishmentCollection(up, jsonObject);
        return up;
    }

    // MODIFIES: account
    // EFFECTS: parses mood collection from JSON object and adds them to unipalboard
    private void addMoodCollection(UniPalBoard up, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("moodCollection");
        for (Object json : jsonArray) {
            JSONObject nextMood = (JSONObject) json;
            addMood(up, nextMood);
        }
    }

    // MODIFIES: account
    // EFFECTS: parses accomplishment from JSON object and adds them to unipalboard
    private void addAccomplishment(UniPalBoard up, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String date = jsonObject.getString("date");
        Accomplishment accomplishment = new Accomplishment(name, date);
        up.addAccomplishment(accomplishment);
    }

    // MODIFIES: account
    // EFFECTS: parses accomplishment collection from JSON object and adds them to
    // unipalboard
    private void addAccomplishmentCollection(UniPalBoard up, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("accomplishmentCollection");
        for (Object json : jsonArray) {
            JSONObject nextAccomplishment = (JSONObject) json;
            addAccomplishment(up, nextAccomplishment);
        }
    }

    // MODIFIES: account
    // EFFECTS: parses mood from JSON object and adds them to unipalboard
    private void addMood(UniPalBoard up, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String type = jsonObject.getString("type");
        String date = jsonObject.getString("date");
        Mood mood = new Mood(name, type, date);
        up.addMood(mood);
    }
}
