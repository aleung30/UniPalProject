package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccomplishmentTest {
    private Accomplishment testAccomplishment;

    @BeforeEach
    void runBefore() {
        testAccomplishment = new Accomplishment("Scored 100 on Math 101 midterm", "Oct 6, 2024");
    }

    @Test
    void testConstructor() {
        assertEquals("Scored 100 on Math 101 midterm", testAccomplishment.getName());
        assertEquals("Oct 6, 2024", testAccomplishment.getDate());
    }

    @Test
    void testChangeName() {
        testAccomplishment.changeName("Scored 90 on Math 101 midterm");
        assertEquals("Scored 90 on Math 101 midterm", testAccomplishment.getName());
    }
    
    @Test
    void testChangeDate() {
        testAccomplishment.changeDate("Oct 7, 2024");
        assertEquals("Oct 7, 2024", testAccomplishment.getDate());
    }
    

}
