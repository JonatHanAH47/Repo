import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Student test class for Property.java with exactly 6 test methods
 */
public class PropertyTestStudent {
    private Property property1, property2, property3;
    
    @Before
    public void setUp() throws Exception {
        property1 = new Property("Beach House", "Malibu", 5000.00, "Owner1");
        property2 = new Property("Mountain Cabin", "Aspen", 4000.00, "Owner2", 1, 1, 2, 2);
        property3 = new Property(property1); // Copy constructor
    }

    @After
    public void tearDown() throws Exception {
        property1 = property2 = property3 = null;
    }

    // Test 1: Default Constructor
    @Test
    public void testDefaultConstructor() {
        Property property = new Property();
        assertEquals("", property.getPropertyName());
        assertEquals(0.0, property.getRentAmount(), 0.01);
    }

    // Test 2: Basic Constructor (4 args)
    @Test
    public void testBasicConstructor() {
        assertEquals("Beach House", property1.getPropertyName());
        assertEquals("Malibu", property1.getCity());
        assertEquals(5000.00, property1.getRentAmount(), 0.01);
    }

    // Test 3: Full Constructor (8 args)
    @Test
    public void testFullConstructor() {
        assertEquals(1, property2.getPlot().getX());
        assertEquals(2, property2.getPlot().getDepth());
    }

    // Test 4: Copy Constructor
    @Test
    public void testCopyConstructor() {
        assertEquals(property1.getPropertyName(), property3.getPropertyName());
        assertEquals(property1.getRentAmount(), property3.getRentAmount(), 0.01);
    }

    // Test 5: getPlot()
    @Test
    public void testGetPlot() {
        assertNotNull(property1.getPlot()); // Default plot
        assertEquals(1, property2.getPlot().getX()); // Custom plot
    }

    // Test 6: toString()
    @Test
    public void testToString() {
        assertEquals("Beach House,Malibu,Owner1,5000.0", property1.toString());
    }
}