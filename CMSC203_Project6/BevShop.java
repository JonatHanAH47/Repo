/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The BevShop class serves as the central manager for the beverage shop system, 
 * handling all order processing and business logic. It enforces key rules like operating hours 
 * (8am-11pm), alcohol age restrictions (21+), and maximum limits on drinks/fruits while tracking 
 * monthly sales data. The class coordinates between customer orders and beverage objects, providing 
 * methods to create orders, add drinks, calculate totals, and generate sales reports.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Manages all operations of the beverage shop
 */
public class BevShop implements BevShopInterface {
    private final ArrayList<Order> orders;
    private int currentAlcoholDrinks;
    
    public BevShop() {
        orders = new ArrayList<>();
        currentAlcoholDrinks = 0;
    }
    
    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }
    
    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }
    
    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }
    
    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }
    
    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }
    
    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }
    
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (isValidTime(time)) {
            Customer customer = new Customer(customerName, customerAge);
            orders.add(new Order(time, day, customer));
            currentAlcoholDrinks = 0;
        }
    }
    
    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }
    
    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            getCurrentOrder().addNewBeverage(bevName, size);
            currentAlcoholDrinks++;
        }
    }
    
    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (!isMaxFruit(numOfFruits)) {
            getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }
    
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        return index != -1 ? orders.get(index).calcOrderTotal() : 0.0;
    }
    
    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order o : orders) {
            total += o.calcOrderTotal();
        }
        return total;
    }
    
    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }
    
    @Override
    public Order getCurrentOrder() {
        return !orders.isEmpty() ? orders.get(orders.size() - 1) : null;
    }
    
    @Override
    public Order getOrderAtIndex(int index) {
        return (index >= 0 && index < orders.size()) ? orders.get(index) : null;
    }
    
    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }
    
    @Override
    public boolean isEligibleForMore() {
        return currentAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }
    
    @Override
    public int getNumOfAlcoholDrink() {
        return currentAlcoholDrinks;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Orders:\n");
        for (Order o : orders) {
            sb.append(o.toString()).append("\n");
        }
        sb.append("Total Monthly Sales: $").append(String.format("%.2f", totalMonthlySale()));
        return sb.toString();
    }
}