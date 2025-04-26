/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The Beverage class serves as the abstract base class for all drink types in the 
 * beverage shop system, defining common properties like name, size, and type. It enforces consistent 
 * structure through an abstract calcPrice() method that each subclass (Coffee, Alcohol, Smoothie) must 
 * implement with their specific pricing logic. The class also provides shared functionality including 
 * size-based pricing calculations and standardized methods like equals() and toString() for uniform behavior 
 * across all beverage objects.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * Abstract class representing a beverage
 */
public abstract class Beverage {
    private final String bevName;
    private final Type type;
    private final Size size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_PRICE = 0.5;

    /**
     * Creates a Beverage object
     * @param bevName Beverage name
     * @param type Beverage type
     * @param size Beverage size
     */
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    /**
     * Calculates price based on size
     * @return Price including size upgrade
     */
    public double addSizePrice() {
        switch(size) {
            case SMALL:
                return BASE_PRICE;
            case MEDIUM:
                return BASE_PRICE + SIZE_PRICE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_PRICE;
            default:
                return BASE_PRICE;
        }
    }

    /**
     * Abstract method to calculate final price
     * @return Total beverage price
     */
    public abstract double calcPrice();

    /**
     * Gets base price
     * @return Base price of beverage
     */
    public double getBasePrice() {
        return BASE_PRICE;
    }

    /**
     * Gets beverage name
     * @return Beverage name
     */
    public String getBevName() {
        return bevName;
    }

    /**
     * Gets beverage type
     * @return Beverage type
     */
    public Type getType() {
        return type;
    }

    /**
     * Gets beverage size
     * @return Beverage size
     */
    public Size getSize() {
        return size;
    }

    /**
     * String representation of beverage
     * @return String in format "name,size"
     */
    @Override
    public String toString() {
        return bevName + "," + size;
    }

    /**
     * Checks equality of beverages
     * @param anotherBev Another beverage to compare
     * @return true if name, type and size match
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (!(anotherBev instanceof Beverage)) return false;
        Beverage beverage = (Beverage) anotherBev;
        return bevName.equals(beverage.bevName) && 
               type == beverage.type && 
               size == beverage.size;
    }
}