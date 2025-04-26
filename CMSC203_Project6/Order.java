/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The Order class represents individual transactions, tracking order time, 
 * day, customer details, and a list of beverages. It implements pricing calculations for 
 * the entire order and enforces beverage-type-specific rules through the OrderInterface.
 * The class supports comparison operations for sorting and provides detailed string representations of orders.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an order containing multiple beverages
 */
public class Order implements OrderInterface, Comparable<Order> {
    private final int orderNo;
    private final int orderTime;
    private final Day orderDay;
    private final Customer customer;
    private final ArrayList<Beverage> beverages;
    
    /**
     * Creates a new order
     * @param orderTime Time of order (8-23)
     * @param orderDay Day of order
     * @param cust Customer making the order
     */
    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderNo = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(cust); // Deep copy
        this.beverages = new ArrayList<>();
    }
    
    private int generateOrder() {
        Random rand = new Random();
        return rand.nextInt(80000) + 10000; // 10000-90000
    }
    
    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }
    
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }
    
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }
    
    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }
    
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }
    
    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage b : beverages) {
            total += b.calcPrice();
        }
        return total;
    }
    
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage b : beverages) {
            if (b.getType() == type) {
                count++;
            }
        }
        return count;
    }
    
    // Getters
    public int getOrderNo() { return orderNo; }
    public int getOrderTime() { return orderTime; }
    public Day getOrderDay() { return orderDay; }
    public Customer getCustomer() { return new Customer(customer); } // Deep copy
    public ArrayList<Beverage> getBeverages() { return new ArrayList<>(beverages); }
    public int getTotalItems() { return beverages.size(); }
    
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order#:").append(orderNo)
          .append(", Time:").append(orderTime)
          .append(", Day:").append(orderDay)
          .append(", Customer:").append(customer.toString())
          .append(", Beverages:[");
        
        for (Beverage b : beverages) {
            sb.append(b.toString()).append("; ");
        }
        
        sb.append("] Total:$").append(String.format("%.2f", calcOrderTotal()));
        return sb.toString();
    }
}