import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {

    private Smoothie sm1, sm2;

    @Before
    public void setUp() throws Exception {
        sm1 = new Smoothie("Berry", Size.SMALL, 2, false);
        sm2 = new Smoothie("Green", Size.MEDIUM, 3, true);
    }

    @After
    public void tearDown() throws Exception {
        sm1 = sm2 = null;
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Berry", sm1.getBevName());
        assertEquals(Type.SMOOTHIE, sm1.getType());
        assertEquals(Size.SMALL, sm1.getSize());
        assertEquals(2, sm1.getNumOfFruits());
        assertFalse(sm1.getAddProtein());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(3.0, sm1.calcPrice(), 0.01);
        assertEquals(6.0, sm2.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(sm1.toString().contains("Berry"));
        assertTrue(sm1.toString().contains("SMALL"));
        assertTrue(sm1.toString().contains("2"));
    }

    @Test
    public void testEquals() {
        Smoothie sm3 = new Smoothie("Berry", Size.SMALL, 2, false);
        Smoothie sm4 = new Smoothie("Berry", Size.SMALL, 3, false);
        
        assertEquals(sm1, sm3);
        assertNotEquals(sm1, sm4);
    }
}