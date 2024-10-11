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
    private Mood testMood3;

    @BeforeEach
    void runBefore() {
        testMoodCollection = new MoodCollection();
        testMood1 = new Mood("Happy because I passed math!", "POSITIVE", "Oct 10, 2024");
        testMood2 = new Mood("Bored", "NEUTRAL", "Oct 10, 2024");
        testMood3 = new Mood("Sad because I failed chemistry!", "NEGATIVE", "Oct 10, 2024");
    }

    @Test
    void testConstructor() {
        assertEquals(0, testMoodCollection.moodSize());
        assertEquals(0, testMoodCollection.getMoodCollection().size());
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
        testMoodCollection.removeMood(testMood2);
        assertEquals(0, testMoodCollection.moodSize());
    }

    @Test
    void testContainsMoodName() {
        testMoodCollection.containsMoodName("Happy because I passed math!");
        assertEquals("Happy because I passed math!", testMood1.getName());
        testMoodCollection.addMood(testMood1);
        assertFalse(testMoodCollection.containsMoodName("Sad because I failed chemistry!"));
        assertTrue(testMoodCollection.containsMoodName("Happy because I passed math!"));
    }

    @Test
    void testContainsTypeName() {
        testMoodCollection.containsMoodType("POSITIVE");
        assertEquals("POSITIVE", testMood1.getType());
        testMoodCollection.addMood(testMood1);
        assertFalse(testMoodCollection.containsMoodType("NEUTRAL"));
        assertTrue(testMoodCollection.containsMoodType("POSITIVE"));
    }

    @Test
    void testSortMoodsByTypeName() {
        testMoodCollection.addMood(testMood1);
        testMoodCollection.addMood(testMood2);
        testMoodCollection.sortMoodsByTypeName("POSITIVE");
        assertTrue(testMoodCollection.containsMoodType("POSITIVE"));
    }

    @Test
    void testGetRecommendation() {
        testMoodCollection.addMood(testMood1);
        testMoodCollection.getRecommendation(testMood1);
        assertEquals("POSITIVE", testMood1.getType());
        assertEquals("That is great to hear!"
                   + " Keep up the positive vibes with meditation, a light walk, or listening to upbeat songs!",
                   testMoodCollection.getRecommendation(testMood1));
        testMoodCollection.getRecommendation(testMood2);
        assertEquals("NEUTRAL", testMood2.getType());
        assertEquals("Feeling neutral is a great way to reflect on yourself!"
                   + " You can engage in gentle stretching, read a book and journal, or watch a relaxing movie!",
                    testMoodCollection.getRecommendation(testMood2));
        testMoodCollection.getRecommendation(testMood3);
        assertEquals("NEGATIVE", testMood3.getType());
        assertEquals("It sounds like you are experiencing some overwhelming emotions!"
                    + " How about some deep breathing exercises or spending time with friends and family?",
                    testMoodCollection.getRecommendation(testMood3));

    }
}
