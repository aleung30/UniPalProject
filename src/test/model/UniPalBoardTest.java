package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniPalBoardTest {
    private MoodCollection testMoodCollection;
    private Mood testMood1;
    private Mood testMood2;
    private Mood testMood3;
    private Accomplishment testAccomplishment1;
    private Accomplishment testAccomplishment2;
    private UniPalBoard uniPal;

    @BeforeEach
    void runBefore() {
        testAccomplishment1 = new Accomplishment("Scored 100 on MATH 101 midterm", "Oct 6, 2024");
        testAccomplishment2 = new Accomplishment("Scored 100 on CPSC 121 midterm", "Oct 6, 2024");
        testMoodCollection = new MoodCollection();
        testMood1 = new Mood("Happy because I passed math!", "POSITIVE", "Oct 10, 2024");
        testMood2 = new Mood("Bored", "NEUTRAL", "Oct 10, 2024");
        testMood3 = new Mood("Sad because I failed chemistry!", "NEGATIVE", "Oct 10, 2024");
        uniPal = new UniPalBoard("Anita");
    }

    @Test
    void testConstructor() {
        assertEquals("Anita", uniPal.getName());
    }

    @Test
    void testAddSingleAccomplishment() {
        uniPal.addAccomplishment(testAccomplishment1);
        assertEquals(1, uniPal.getAccomplishmentCollection().size());
    }

    @Test
    void testAddMultipleAccomplishments() {
        uniPal.addAccomplishment(testAccomplishment1);
        assertEquals(1, uniPal.getAccomplishmentCollection().size());
        uniPal.addAccomplishment(testAccomplishment2);
        assertEquals(2, uniPal.getAccomplishmentCollection().size());

    }

    @Test
    void testAddSingleMood() {
        uniPal.addMood(testMood1);
        assertEquals(1, uniPal.getMoodCollection().size());
    }

    @Test
    void testAddMultipleMoods() {
        uniPal.addMood(testMood1);
        assertEquals(1, uniPal.getMoodCollection().size());
        uniPal.addMood(testMood2);
        assertEquals(2, uniPal.getMoodCollection().size());
    }

    @Test
    void testContainsMoodName() {
        uniPal.containsMoodName("Happy because I passed math!");
        assertEquals("Happy because I passed math!", testMood1.getName());
        uniPal.addMood(testMood1);
        assertFalse(uniPal.containsMoodName("Sad because I failed chemistry!"));
        assertTrue(uniPal.containsMoodName("Happy because I passed math!"));
    }

    @Test
    void testGetRecommendation() {
        uniPal.addMood(testMood1);
        uniPal.getRecommendation(testMood1);
        assertEquals("POSITIVE", testMood1.getType());
        assertEquals("That is great to hear!"
                + " Keep up the positive vibes with meditation, a light walk, or listening to upbeat songs!",
                testMoodCollection.getRecommendation(testMood1));
        uniPal.getRecommendation(testMood2);
        assertEquals("NEUTRAL", testMood2.getType());
        assertEquals("Feeling neutral is a great way to reflect on yourself!"
                + " You can engage in gentle stretching, read a book and journal, or watch a relaxing movie!",
                testMoodCollection.getRecommendation(testMood2));
        uniPal.getRecommendation(testMood3);
        assertEquals("NEGATIVE", testMood3.getType());
        assertEquals("It sounds like you are experiencing some overwhelming emotions!"
                + " How about some deep breathing exercises or spending time with friends and family?",
                testMoodCollection.getRecommendation(testMood3));
    }

}
