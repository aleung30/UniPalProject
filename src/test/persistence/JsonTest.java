package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Accomplishment;
import model.Mood;

public class JsonTest {
    protected void checkMood(String name, String type, String date, Mood mood) {
        assertEquals(name, mood.getName());
        assertEquals(date, mood.getDate());
        assertEquals(type, mood.getType());
    }
    
    protected void checkAccomplishment(String name, String date, Accomplishment accomplishment) {
        assertEquals(name, accomplishment.getName());
        assertEquals(date, accomplishment.getDate());
    }

}
