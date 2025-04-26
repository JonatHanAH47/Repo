/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The Smoothie class handles fruit-based drink orders, tracking fruit count (up to 5) and 
 * protein supplements with corresponding price adjustments. It enforces maximum fruit limits and 
 * integrates with the shop’s order system through the Beverage superclass.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * Represents a Smoothie beverage
 */
public class Smoothie extends Beverage {
    private final int numOfFruits;
    private final boolean addProtein;
    private static final double PROTEIN_PRICE = 1.5;
    private static final double FRUIT_PRICE = 0.5;
    private static final int MAX_FRUITS = 5;

    /**
     * Creates a Smoothie beverage
     * @param bevName Name of smoothie
     * @param size Size of smoothie
     * @param numOfFruits Number of fruits
     * @param addProtein Whether protein is added
     */
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = Math.min(numOfFruits, MAX_FRUITS);
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        price += numOfFruits * 0.5;
        if (addProtein) price += 1.5;
        if (getSize() == Size.MEDIUM) price += 0.5; 
        return price;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public boolean getAddProtein() {
        return addProtein;
    }

    @Override
    public String toString() {
        return super.toString() + "," + addProtein + "," + numOfFruits + "," + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Smoothie)) return false;
        Smoothie other = (Smoothie) obj;
        return this.numOfFruits == other.numOfFruits && 
               this.addProtein == other.addProtein;
    }
}