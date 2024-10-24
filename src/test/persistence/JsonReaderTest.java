package persistence;

import model.UniPalBoard;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            UniPalBoard up = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyUniPal() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyUniPal.json");
        try {
            UniPalBoard up = reader.read();
            assertEquals("My uni pal", up.getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralUniPal() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralUniPal.json");
        try {
            UniPalBoard up = reader.read();
            assertEquals("My uni pal", up.getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
