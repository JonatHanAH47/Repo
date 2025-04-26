import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DayTestStudent {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValues() {
        Day[] days = Day.values();
        assertEquals(7, days.length);
        assertEquals(Day.MONDAY, days[0]);
        assertEquals(Day.SUNDAY, days[6]);
    }

    @Test
    public void testValueOfValid() {
        assertEquals(Day.TUESDAY, Day.valueOf("TUESDAY"));
        assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalid() {
        Day.valueOf("INVALID_DAY");
    }

    @Test(expected = NullPointerException.class)
    public void testValueOfNull() {
        Day.valueOf(null);
    }
}