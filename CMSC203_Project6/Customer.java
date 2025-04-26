/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The Customer class models shop patrons with name and age properties, 
 * enforcing age validation for alcohol purchases through its methods. It includes copy 
 * constructor functionality to safely duplicate customer data when creating new orders. 
 * The class integrates with the order system while maintaining encapsulation of customer information.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * Represents a customer at the beverage shop
 */
public class Customer {
    private String name;
    private int age;

    /**
     * Creates a Customer with specified name and age
     * @param name Customer name
     * @param age Customer age
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor - creates a new Customer from an existing one
     * @param c Customer to copy
     */
    public Customer(Customer c) {
        this.name = c.name;
        this.age = c.age;
    }

    /**
     * Gets customer age
     * @return age of customer
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets customer name
     * @return name of customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets customer age
     * @param age New age value
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets customer name
     * @param name New name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * String representation of customer
     * @return String in format "Name: [name], Age: [age]"
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    /**
     * Creates a deep copy of this customer
     * @return New Customer object with same properties
     */
    public Customer deepCopy() {
        return new Customer(this.name, this.age);
    }
}