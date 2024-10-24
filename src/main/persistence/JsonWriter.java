package persistence;

import model.UniPalBoard;

import java.io.*;

// Represents a writer that writes JSON representation of unipalboard to file
public class JsonWriter {

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {

    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file
    // cannot
    // be opened for writing
    public void open() throws FileNotFoundException {

    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of unipalboard to file
    public void write(UniPalBoard up) {

    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {

    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {

    }
}
