/**
 * Test class for HolidayBonus
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {

    private double[][] dataSet;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // Sample data set
        dataSet = new double[][] {
            {1000.0, 2000.0, 3000.0},
            {4000.0, 5000.0},
            {6000.0, 7000.0, 8000.0, 9000.0}
        };
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        dataSet = null;
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] expectedBonuses = {3000.0, 4000.0, 20000.0};
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(dataSet);
        
        assertArrayEquals(expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double expectedTotal = 27000.0;
        double actualTotal = HolidayBonus.calculateTotalHolidayBonus(dataSet);
        
        assertEquals(expectedTotal, actualTotal, 0.001);
    }
}