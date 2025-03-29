import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Student test class for Plot.java with exactly 7 test methods
 */
public class PlotTestStudent {
    private Plot plot1, plot2, plot3, plot4, plot5;
    
    @Before
    public void setUp() throws Exception {
        plot1 = new Plot(2, 2, 6, 6);
        plot2 = new Plot(3, 3, 4, 4);
        plot3 = new Plot(10, 10, 2, 2);
        plot4 = new Plot(2, 2, 5, 5);
        plot5 = new Plot(8, 8, 2, 2);
    }

    @After
    public void tearDown() throws Exception {
        plot1 = plot2 = plot3 = plot4 = plot5 = null;
    }

    // Test 1: Default Constructor
    @Test
    public void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    // Test 2: Parameterized Constructor
    @Test
    public void testParameterizedConstructor() {
        assertEquals(2, plot1.getX());
        assertEquals(2, plot1.getY());
        assertEquals(6, plot1.getWidth());
        assertEquals(6, plot1.getDepth());
    }

    // Test 3: Copy Constructor
    @Test
    public void testCopyConstructor() {
        Plot copy = new Plot(plot1);
        assertEquals(plot1.getX(), copy.getX());
        assertEquals(plot1.getDepth(), copy.getDepth());
    }

    // Test 4: overlaps()
    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot3));
    }

    // Test 5: encompasses()
    @Test
    public void testEncompasses() {
        assertTrue(plot1.encompasses(plot2));  // Fully contained
        assertTrue(plot1.encompasses(plot4));  // Edge-aligned
        assertTrue(plot1.encompasses(new Plot(2, 2, 6, 6))); // Identical plot
        
        assertFalse(plot1.encompasses(plot3)); // Larger plot
        assertFalse(plot1.encompasses(plot5)); // Partially outside
        assertFalse(plot1.encompasses(new Plot(1, 1, 1, 1))); // Completely outside
    }

    // Test 6: toString()
    @Test
    public void testToString() {
        assertEquals("2,2,6,6", plot1.toString());
    }

    // Test 7: Setters
    @Test
    public void testSetters() {
        plot1.setX(5);
        plot1.setY(5);
        plot1.setWidth(10);
        plot1.setDepth(10);
        assertEquals(5, plot1.getX());
        assertEquals(10, plot1.getDepth());
    }
}