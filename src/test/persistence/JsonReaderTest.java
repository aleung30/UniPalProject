package persistence;

import model.UniPalBoard;
import model.Accomplishment;
import model.Mood;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

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
            assertEquals(0, up.getMoodCollection().size());
            assertEquals(0, up.getAccomplishmentCollection().size());
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
            List<Mood> moods = up.getMoodCollection();
            List<Accomplishment> accomplishments = up.getAccomplishmentCollection();
            assertEquals(2, moods.size());
            assertEquals(1, accomplishments.size());
            checkAccomplishment("passed math 100", "Oct 23, 2024", accomplishments.get(0));
            checkMood("passed", "POSITIVE", "Oct 23, 2024", moods.get(0));
            checkMood("failed", "NEGATIVE", "Oct 23, 2024", moods.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
