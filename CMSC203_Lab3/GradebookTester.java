import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

    private GradeBook g1;
    private GradeBook g2;

    @BeforeEach
    void setUp() throws Exception {
        // Create two GradeBook objects with a capacity of 5
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        // Add scores to the first GradeBook object
        g1.addScore(45);
        g1.addScore(60);
        g1.addScore(85);

        // Add scores to the second GradeBook object
        g2.addScore(95);
        g2.addScore(70);
        g2.addScore(80);
        g2.addScore(65);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Set the GradeBook objects to null
        g1 = null;
        g2 = null;
    }

    @Test
    void testAddScore() {
        // Test the contents of the scores array using toString()
        assertTrue(g1.toString().equals("45.0 60.0 85.0"));
        assertTrue(g2.toString().equals("95.0 70.0 80.0 65.0"));

        // Test the scoreSize after adding scores
        assertEquals(3, g1.getScoreSize(), 0.001);
        assertEquals(4, g2.getScoreSize(), 0.001);
    }

    @Test
    void testSum() {
        // Test the sum of scores for both GradeBook objects
        assertEquals(190, g1.sum(), 0.001); // 45 + 60 + 85 = 190
        assertEquals(310, g2.sum(), 0.001); // 95 + 70 + 80 + 65 = 310
    }

    @Test
    void testMinimum() {
        // Test the minimum score for both GradeBook objects
        assertEquals(45, g1.minimum(), 0.001);
        assertEquals(65, g2.minimum(), 0.001);
    }

    @Test
    void testFinalScore() {
        // Test the final score (sum - minimum) for both GradeBook objects
        assertEquals(145, g1.finalScore(), 0.001); // 190 - 45 = 145
        assertEquals(245, g2.finalScore(), 0.001); // 310 - 65 = 245
    }
}