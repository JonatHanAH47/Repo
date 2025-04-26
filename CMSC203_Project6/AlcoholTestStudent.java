import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTestStudent {

    private Alcohol alc1, alc2;

    @Before
    public void setUp() throws Exception {
        alc1 = new Alcohol("Beer", Size.SMALL, false);
        alc2 = new Alcohol("Wine", Size.LARGE, true);
    }

    @After
    public void tearDown() throws Exception {
        alc1 = alc2 = null;
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Beer", alc1.getBevName());
        assertEquals(Type.ALCOHOL, alc1.getType());
        assertEquals(Size.SMALL, alc1.getSize());
        assertFalse(alc1.isWeekend());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(2.0, alc1.calcPrice(), 0.01);
        assertEquals(3.6, alc2.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(alc1.toString().contains("Beer"));
        assertTrue(alc1.toString().contains("SMALL"));
        assertTrue(alc1.toString().contains("false"));
    }

    @Test
    public void testEquals() {
        Alcohol alc3 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol alc4 = new Alcohol("Beer", Size.MEDIUM, false);
        
        assertEquals(alc1, alc3);
        assertNotEquals(alc1, alc4);
    }
}