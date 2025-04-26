import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

    private Order order;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("John", 25);
        order = new Order(12, Day.MONDAY, customer);
    }

    @After
    public void tearDown() throws Exception {
        order = null;
        customer = null;
    }

    @Test
    public void testGetOrderNo() {
        assertTrue(order.getOrderNo() >= 10000 && order.getOrderNo() <= 90000);
    }

    @Test
    public void testGetOrderTime() {
        assertEquals(12, order.getOrderTime());
    }

    @Test
    public void testGetOrderDay() {
        assertEquals(Day.MONDAY, order.getOrderDay());
    }

    @Test
    public void testGetCustomer() {
        assertEquals("John", order.getCustomer().getName());
    }

    @Test
    public void testIsWeekend() {
        assertFalse(order.isWeekend());
        Order weekendOrder = new Order(12, Day.SATURDAY, customer);
        assertTrue(weekendOrder.isWeekend());
    }

    @Test
    public void testGetBeverage() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertNotNull(order.getBeverage(0));
        assertNull(order.getBeverage(1));
    }

    @Test
    public void testAddNewBeverageCoffee() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(Type.COFFEE, order.getBeverage(0).getType());
    }

    @Test
    public void testAddNewBeverageAlcohol() {
        order.addNewBeverage("Beer", Size.SMALL);
        assertEquals(Type.ALCOHOL, order.getBeverage(0).getType());
    }

    @Test
    public void testAddNewBeverageSmoothie() {
        order.addNewBeverage("Berry", Size.LARGE, 3, true);
        assertEquals(Type.SMOOTHIE, order.getBeverage(0).getType());
    }

    @Test
    public void testCalcOrderTotal() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Beer", Size.SMALL);
        assertTrue(order.calcOrderTotal() > 0);
    }

    @Test
    public void testFindNumOfBeveType() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Beer", Size.SMALL);
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    public void testGetTotalItems() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, order.getTotalItems());
    }

    @Test
    public void testCompareTo() {
        Order otherOrder = new Order(10, Day.MONDAY, customer);
        assertTrue(order.compareTo(otherOrder) != 0);
    }

    @Test
    public void testToString() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertTrue(order.toString().contains("Latte"));
        assertTrue(order.toString().contains("12"));
        assertTrue(order.toString().contains("MONDAY"));
    }

    @Test
    public void testGetBeverages() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, order.getBeverages().size());
    }
}