package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoodTest {
    private Mood testMood;
    
    @BeforeEach
    void runBefore() {
        testMood = new Mood("Happy", "Positive", "Oct 6, 2024");
    }

    @Test
    void testConstructor() {
        assertEquals("Happy", testMood.getName());
        assertEquals("Positive", testMood.getType());
        assertEquals("Oct 6, 2024", testMood.getDate());
    }

    @Test
    void testChangeName() {
        testMood.changeName("Sad");
        assertEquals("Sad", testMood.getName());
    }

    @Test
    void testChangeType() {
        testMood.changeType("Negative");
        assertEquals("Negative", testMood.getType());
    }

    @Test
    void testChangeDate() {
        testMood.changeDate("Oct 7, 2024");
        assertEquals("Oct 7, 2024", testMood.getDate());
    }
}
