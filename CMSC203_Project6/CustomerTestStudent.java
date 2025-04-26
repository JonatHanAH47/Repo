import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTestStudent {

    private Customer customer;
    private Customer copy;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("John", 25);
        copy = new Customer(customer);
    }

    @After
    public void tearDown() throws Exception {
        customer = null;
        copy = null;
    }

    @Test
    public void testConstructor() {
        assertEquals("John", customer.getName());
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(customer.getName(), copy.getName());
        assertEquals(customer.getAge(), copy.getAge());
    }

    @Test
    public void testGetAge() {
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testGetName() {
        assertEquals("John", customer.getName());
    }

    @Test
    public void testSetAge() {
        customer.setAge(30);
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testSetName() {
        customer.setName("Mike");
        assertEquals("Mike", customer.getName());
    }

    @Test
    public void testToString() {
        assertTrue(customer.toString().contains("John"));
        assertTrue(customer.toString().contains("25"));
    }

    @Test
    public void testDeepCopy() {
        Customer deepCopy = customer.deepCopy();
        assertEquals(customer.getName(), deepCopy.getName());
        assertEquals(customer.getAge(), deepCopy.getAge());
        assertNotSame(customer, deepCopy);
    }
}