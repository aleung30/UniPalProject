package persistence;

import model.UniPalBoard;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            UniPalBoard up = new UniPalBoard("My uni pal");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyUniPal() {
        try {
            UniPalBoard up = new UniPalBoard("My uni pal");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyUniPaljson");
            writer.open();
            writer.write(up);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyUniPal.json");
            up = reader.read();
            assertEquals("My uni pal", up.getName());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralUniPal() {
        try {
            UniPalBoard up = new UniPalBoard("My uni pal");
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralUniPal.json");
            writer.open();
            writer.write(up);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralUniPal.json");
            up = reader.read();
            assertEquals("My uni pal", up.getName());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
