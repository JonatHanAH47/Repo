import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SizeTestStudent {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValues() {
        Size[] sizes = Size.values();
        assertEquals(3, sizes.length);
        assertEquals(Size.SMALL, sizes[0]);
        assertEquals(Size.LARGE, sizes[2]);
    }

    @Test
    public void testValueOfValid() {
        assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"));
        assertEquals(Size.SMALL, Size.valueOf("SMALL"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalid() {
        Size.valueOf("EXTRA_LARGE");
    }

    @Test(expected = NullPointerException.class)
    public void testValueOfNull() {
        Size.valueOf(null);
    }
}