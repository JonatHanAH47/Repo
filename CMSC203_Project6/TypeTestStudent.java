import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeTestStudent {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValues() {
        Type[] types = Type.values();
        assertEquals(3, types.length);
        assertEquals(Type.ALCOHOL, types[0]);
        assertEquals(Type.SMOOTHIE, types[2]);
    }

    @Test
    public void testValueOfValid() {
        assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
        assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalid() {
        Type.valueOf("TEA");
    }

    @Test(expected = NullPointerException.class)
    public void testValueOfNull() {
        Type.valueOf(null);
    }
}