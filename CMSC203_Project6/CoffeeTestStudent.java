import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {

    private Coffee cf1, cf2;

    @Before
    public void setUp() throws Exception {
        cf1 = new Coffee("Regular", Size.MEDIUM, false, false);
        cf2 = new Coffee("Special", Size.LARGE, true, true);
    }

    @After
    public void tearDown() throws Exception {
        cf1 = cf2 = null;
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Regular", cf1.getBevName());
        assertEquals(Type.COFFEE, cf1.getType());
        assertEquals(Size.MEDIUM, cf1.getSize());
        assertFalse(cf1.getExtraShot());
        assertFalse(cf1.getExtraSyrup());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(3.0, cf1.calcPrice(), 0.01);
        assertEquals(4.0, cf2.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(cf1.toString().contains("Regular"));
        assertTrue(cf1.toString().contains("MEDIUM"));
        assertTrue(cf1.toString().contains("false,false"));
    }

    @Test
    public void testEquals() {
        Coffee cf3 = new Coffee("Regular", Size.MEDIUM, false, false);
        Coffee cf4 = new Coffee("Regular", Size.MEDIUM, true, false);
        
        assertEquals(cf1, cf3);
        assertNotEquals(cf1, cf4);
    }
}