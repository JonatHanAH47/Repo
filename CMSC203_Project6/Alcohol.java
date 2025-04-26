/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The **Alcohol** class models alcoholic drink orders in the beverage shop system, 
 * implementing size-based pricing with an automatic weekend surcharge. It integrates with the shop's 
 * age verification and enforces business rules like the maximum of 3 alcoholic drinks per order.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * Represents an Alcoholic beverage
 */
public class Alcohol extends Beverage {
    private final boolean isWeekend;
    private static final double WEEKEND_PRICE = 0.6;

    /**
     * Creates an Alcohol beverage
     * @param bevName Name of drink
     * @param size Size of drink
     * @param isWeekend Whether it's a weekend
     */
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (isWeekend) price += WEEKEND_PRICE;
        return price;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    @Override
    public String toString() {
        return super.toString() + "," + isWeekend + "," + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Alcohol)) return false;
        Alcohol other = (Alcohol) obj;
        return this.isWeekend == other.isWeekend;
    }
}