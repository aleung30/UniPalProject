package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoodCollectionTest {
    private MoodCollection testMoodCollection;
    private Mood testMood1;
    private Mood testMood2;

    @BeforeEach
    void runBefore() {
        testMoodCollection = new MoodCollection();
        testMood1 = new Mood("Happy because I passed math!", "POSITIVE", "Oct 10, 2024");
        testMood2 = new Mood("Sad because I failed chemistry!", "NEGATIVE", "Oct 10, 2024");
    }

    @Test
    void testConstructor() {
        assertEquals(0, testMoodCollection.moodSize());
    }

    @Test
    void testAddSingleMood() {
        testMoodCollection.addMood(testMood1);
        assertEquals(1, testMoodCollection.moodSize());
    }

    @Test
    void testAddMultipleMoods() {
        testMoodCollection.addMood(testMood1);
        assertEquals(1, testMoodCollection.moodSize());
        testMoodCollection.addMood(testMood2);
        assertEquals(2, testMoodCollection.moodSize());
    }

    @Test
    void testRemoveSingleMood() {
        testMoodCollection.removeMood(testMood1);
        assertEquals(0, testMoodCollection.moodSize());
    }

    @Test
    void testRemoveMultipleMoods() {
        testMoodCollection.addMood(testMood1);
        testMoodCollection.addMood(testMood2);
        testMoodCollection.removeMood(testMood1);
        assertEquals(1, testMoodCollection.moodSize());
        testMoodCollection.removeMood(testMood1);
        assertEquals(0, testMoodCollection.moodSize());
    }

    @Test
    void testContainsMood() {
        testMoodCollection.containsMood("Happy because I passed math!", "POSITIVE", "Oct 10, 2024");
        assertEquals("Happy because I passed math!", testMood1.getName());
        testMoodCollection.addMood(testMood1);
        assertFalse(testMoodCollection.containsMood("Sad because I failed chemistry!", "NEGATIVE", "Oct 10, 2024"));
        assertTrue(testMoodCollection.containsMood("Happy because I passed math!", "POSITIVE", "Oct 10, 2024"));
    }

    @Test
    void testSortMoodsByTypeName() {
        testMoodCollection.addMood(testMood1);
        testMoodCollection.addMood(testMood2);
        testMoodCollection.sortMoodsByTypeName("POSITIVE");
        assertEquals(testMood1, testMoodCollection.sortMoodsByTypeName("POSITIVE"));
    }

}
