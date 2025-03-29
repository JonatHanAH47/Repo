import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Student test class for ManagementCompany.java with 15 test methods
 */
public class ManagementCompanyTestStudent {
    private ManagementCompany mgmtCo;
    private Property property1, property2, property3, property4, property5, property6;
    
    @Before
    public void setUp() throws Exception {
        mgmtCo = new ManagementCompany("Dream Properties", "DP123", 8.0, 0, 0, 10, 10);
        property1 = new Property("Beach Villa", "Malibu", 4500.00, "Surf LLC", 1, 1, 2, 2);
        property2 = new Property("Mountain Cabin", "Aspen", 3800.00, "Alpine Inc", 3, 3, 2, 2);
        property3 = new Property("City Loft", "Chicago", 3200.00, "Urban Dev", 5, 5, 2, 2);
        property4 = new Property("Overlap Prop", "Test", 1000.00, "Owner", 1, 1, 2, 2);
        property5 = new Property("Too Big", "Test", 1000.00, "Owner", 15, 15, 20, 20);
        property6 = new Property("Null Owner", "Test", 1000.00, null, 7, 7, 1, 1);
    }

    @After
    public void tearDown() throws Exception {
        mgmtCo = null;
        property1 = property2 = property3 = property4 = property5 = property6 = null;
    }

    // Test 1: Default Constructor
    @Test
    public void testDefaultConstructor() {
        ManagementCompany defaultCo = new ManagementCompany();
        assertEquals("", defaultCo.getName());
        assertEquals("", defaultCo.getTaxID());
        assertEquals(0.0, defaultCo.getMgmFeePer(), 0.01);
        assertEquals(0, defaultCo.getPlot().getX());
        assertEquals(0, defaultCo.getPlot().getY());
    }

    // Test 2: Three-arg Constructor
    @Test
    public void testThreeArgConstructor() {
        assertEquals("Dream Properties", mgmtCo.getName());
        assertEquals("DP123", mgmtCo.getTaxID());
        assertEquals(8.0, mgmtCo.getMgmFeePer(), 0.01);
        assertEquals(10, mgmtCo.getPlot().getWidth());
        assertEquals(10, mgmtCo.getPlot().getDepth());
    }

    // Test 3: Seven-arg Constructor
    @Test
    public void testSevenArgConstructor() {
        ManagementCompany customCo = new ManagementCompany("Test", "T123", 5.0, 2, 2, 8, 8);
        assertEquals(2, customCo.getPlot().getX());
        assertEquals(2, customCo.getPlot().getY());
        assertEquals(8, customCo.getPlot().getWidth());
    }

    // Test 4: Copy Constructor
    @Test
    public void testCopyConstructor() {
        mgmtCo.addProperty(property1);
        ManagementCompany copyCo = new ManagementCompany(mgmtCo);
        assertEquals(mgmtCo.getName(), copyCo.getName());
        assertEquals(mgmtCo.getPropertiesCount(), copyCo.getPropertiesCount());
    }

    // Test 5: addProperty(Property)
    @Test
    public void testAddPropertyObject() {
        assertEquals(0, mgmtCo.addProperty(property1));
        assertEquals(1, mgmtCo.addProperty(property2));
    }

    // Test 6: addProperty(name,city,rent,owner)
    @Test
    public void testAddPropertyBasic() {
        assertEquals(0, mgmtCo.addProperty("Lake House", "Tahoe", 2500.00, "Vacation Inc"));
    }

    // Test 7: addProperty(name,city,rent,owner,x,y,width,depth)
    @Test
    public void testAddPropertyWithPlot() {
        assertEquals(0, mgmtCo.addProperty("Farm", "Iowa", 1500.00, "Agri Corp", 0, 0, 3, 3));
    }

    // Test 8: getHighestRentProperty
    @Test
    public void testGetHighestRentProperty() {
        mgmtCo.addProperty(property1);
        mgmtCo.addProperty(property2);
        mgmtCo.addProperty(property3);
        assertEquals(property1, mgmtCo.getHighestRentPropperty());
    }

    // Test 9: getTotalRent
    @Test
    public void testGetTotalRent() {
        mgmtCo.addProperty(property1);
        mgmtCo.addProperty(property2);
        assertEquals(4500.00 + 3800.00, mgmtCo.getTotalRent(), 0.01);
    }

    // Test 10: isPropertiesFull
    @Test
    public void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mgmtCo.addProperty(new Property("Prop "+i, "City", 1000, "Owner", i, 0, 1, 1));
        }
        assertTrue(mgmtCo.isPropertiesFull());
    }

    // Test 11: isManagementFeeValid
    @Test
    public void testIsManagementFeeValid() {
        assertTrue(mgmtCo.isMangementFeeValid());
        ManagementCompany invalidCo = new ManagementCompany("Bad", "B123", 150.0);
        assertFalse(invalidCo.isMangementFeeValid());
    }

    // Test 12: getPropertiesCount
    @Test
    public void testGetPropertiesCount() {
        mgmtCo.addProperty(property1);
        mgmtCo.addProperty(property2);
        assertEquals(2, mgmtCo.getPropertiesCount());
    }

    // Test 13: removeLastProperty
    @Test
    public void testRemoveLastProperty() {
        mgmtCo.addProperty(property1);
        mgmtCo.addProperty(property2);
        mgmtCo.removeLastProperty();
        assertEquals(1, mgmtCo.getPropertiesCount());
    }

    // Test 14: addProperty error conditions
    @Test
    public void testAddPropertyErrors() {
        // 1. Test null property
        assertEquals(-2, mgmtCo.addProperty(null));
        
        // 2. Test not encompassed
        Property bigProp = new Property("Too Big", "City", 1000, "Owner", 5, 5, 20, 20);
        assertEquals(-3, mgmtCo.addProperty(bigProp));
        
        // 3. Test overlap
        Property overlapProp = new Property("Overlap", "City", 1000, "Owner", 1, 1, 3, 3);
        mgmtCo.addProperty(property1);
        assertEquals(-4, mgmtCo.addProperty(overlapProp));
        
        // 4. Test array full
        mgmtCo = new ManagementCompany("Test", "123", 10); // Reset
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mgmtCo.addProperty(new Property("Prop "+i, "City", 1000, "Owner", i, 0, 1, 1));
        }
        assertEquals(-1, mgmtCo.addProperty(new Property("Extra", "City", 1000, "Owner")));
    }

    // Test 15: toString
    @Test
    public void testToString() {
        mgmtCo.addProperty(property1);
        String expected = "List of the properties for Dream Properties, taxID: DP123\n" +
                         "______________________________________________________\n" +
                         "Beach Villa,Malibu,Surf LLC,4500.0\n" +
                         "______________________________________________________\n\n" +
                         " total management Fee: 360.00";
        assertEquals(expected, mgmtCo.toString());
    }
}