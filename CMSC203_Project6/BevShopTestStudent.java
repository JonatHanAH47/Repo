import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    private BevShop bevShop;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        bevShop = new BevShop();
        customer = new Customer("John", 25);
    }

    @After
    public void tearDown() throws Exception {
        bevShop = null;
        customer = null;
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(12));
        assertFalse(bevShop.isValidTime(7));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() {
        assertFalse(bevShop.isMaxFruit(3));
        assertTrue(bevShop.isMaxFruit(6));
    }

    @Test
    public void testIsValidAge() {
        assertTrue(bevShop.isValidAge(25));
        assertFalse(bevShop.isValidAge(19));
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getCurrentOrder());
        assertEquals(0, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processSmoothieOrder("Berry", Size.MEDIUM, 3, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testFindOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertEquals(0, bevShop.findOrder(orderNo));
    }

    @Test
    public void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        assertTrue(bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()) > 0);
    }

    @Test
    public void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        assertTrue(bevShop.totalMonthlySale() > 0);
    }

    @Test
    public void testTotalNumOfMonthlyOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testGetCurrentOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    public void testGetOrderAtIndex() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getOrderAtIndex(0));
    }

    @Test
    public void testSortOrders() {
        bevShop.startNewOrder(15, Day.MONDAY, "John", 25);
        int firstOrderNo = bevShop.getCurrentOrder().getOrderNo();
        
        bevShop.startNewOrder(10, Day.MONDAY, "Mike", 30);
        int secondOrderNo = bevShop.getCurrentOrder().getOrderNo();
        
        assertEquals(secondOrderNo, bevShop.getOrderAtIndex(1).getOrderNo());
        
        bevShop.sortOrders();
        
        assertEquals(10, bevShop.getOrderAtIndex(0).getOrderTime());
        assertEquals(15, bevShop.getOrderAtIndex(1).getOrderTime());
        
        assertEquals(secondOrderNo, bevShop.getOrderAtIndex(0).getOrderNo());
        assertEquals(firstOrderNo, bevShop.getOrderAtIndex(1).getOrderNo());
    }

    @Test
    public void testIsEligibleForMore() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertTrue(bevShop.isEligibleForMore());
    }

    @Test
    public void testGetNumOfAlcoholDrink() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    public void testToString() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertTrue(bevShop.toString().contains("Monthly Orders"));
    }
}