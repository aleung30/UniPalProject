package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccomplishmentCollectionTest {
    private Accomplishment testAccomplishment1;
    private Accomplishment testAccomplishment2;
    private AccomplishmentCollection testAccomplishmentList;

    @BeforeEach
    void runBefore() {
        testAccomplishment1 = new Accomplishment("Scored 100 on MATH 101 midterm", "Oct 6, 2024");
        testAccomplishment2 = new Accomplishment("Scored 100 on CPSC 121 midterm", "Oct 6, 2024");
        testAccomplishmentList = new AccomplishmentCollection();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testAccomplishmentList.accomplishmentSize());
        assertEquals(0, testAccomplishmentList.getAccomplishmentCollection().size());
    }

    @Test
    void testAddSingleAccomplishment() {
        testAccomplishmentList.addAccomplishment(testAccomplishment1);
        assertEquals(1, testAccomplishmentList.accomplishmentSize());
    }

    @Test
    void testAddMultipleAccomplishments() {
        testAccomplishmentList.addAccomplishment(testAccomplishment1);
        assertEquals(1, testAccomplishmentList.accomplishmentSize());
        testAccomplishmentList.addAccomplishment(testAccomplishment2);
        assertEquals(2, testAccomplishmentList.accomplishmentSize());
    }

    @Test
    void testRemoveSingleAccomplishment() {
        testAccomplishmentList.removeAccomplishment(testAccomplishment1);
        assertEquals(0, testAccomplishmentList.accomplishmentSize());
    }

    @Test
    void testRemoveMultipleAccomplishments() {
        testAccomplishmentList.addAccomplishment(testAccomplishment1);
        testAccomplishmentList.addAccomplishment(testAccomplishment2);
        testAccomplishmentList.removeAccomplishment(testAccomplishment1);
        assertEquals(1, testAccomplishmentList.accomplishmentSize());
        testAccomplishmentList.removeAccomplishment(testAccomplishment2);
        assertEquals(0, testAccomplishmentList.accomplishmentSize());
    }

    @Test
    void testContainsAccomplishment() {
        testAccomplishmentList.containsAccomplishment("Scored 100 on MATH 101 midterm", "Oct 6, 2024");
        assertEquals("Scored 100 on MATH 101 midterm", testAccomplishment1.getName());
        testAccomplishmentList.addAccomplishment(testAccomplishment1);
        assertFalse(testAccomplishmentList.containsAccomplishment("Scored 100 on CPSC 121 midterm", "Oct 6, 2024"));
        assertTrue(testAccomplishmentList.containsAccomplishment("Scored 100 on MATH 101 midterm", "Oct 6, 2024"));
    }

}
