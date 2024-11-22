package persistence;

import model.Accomplishment;
import model.Mood;
import model.UniPalBoard;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testWriterEmptyUniPal() {
        try {
            UniPalBoard up = new UniPalBoard("My uni pal");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyUniPal.json");
            writer.open();
            writer.write(up);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyUniPal.json");
            up = reader.read();
            assertEquals("My uni pal", up.getName());
            assertEquals(0, up.getMoodCollection().size());
            assertEquals(0, up.getAccomplishmentCollection().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralUniPal() {
        try {
            UniPalBoard up = new UniPalBoard("My uni pal");
            up.addMood(new Mood("passed", "POSITIVE", "Oct 23, 2024"));
            up.addMood(new Mood("failed", "NEGATIVE", "Oct 23, 2024"));
            up.addAccomplishment(new Accomplishment("passed math 100", "Oct 23, 2024"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralUniPal.json");
            writer.open();
            writer.write(up);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralUniPal.json");
            up = reader.read();
            assertEquals("My uni pal", up.getName());
            List<Mood> moods = up.getMoodCollection();
            List<Accomplishment> accomplishments = up.getAccomplishmentCollection();
            assertEquals(2, moods.size());
            assertEquals(1, accomplishments.size());
            checkAccomplishment("passed math 100", "Oct 23, 2024", accomplishments.get(0));
            checkMood("passed", "POSITIVE", "Oct 23, 2024", moods.get(0));
            checkMood("failed", "NEGATIVE", "Oct 23, 2024", moods.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
