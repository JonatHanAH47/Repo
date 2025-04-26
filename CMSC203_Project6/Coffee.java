/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The Coffee class represents customizable coffee beverages, implementing size options 
 * (small/medium/large) and additional charges for extra shots or syrup. It calculates prices based on 
 * these customizations while inheriting core functionality from the Beverage abstract class.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * Represents a Coffee beverage
 */
public class Coffee extends Beverage {
    private final boolean extraShot;
    private final boolean extraSyrup;
    private static final double EXTRA_SHOT_PRICE = 0.5;
    private static final double EXTRA_SYRUP_PRICE = 0.5;

    /**
     * Creates a Coffee beverage
     * @param bevName Name of coffee
     * @param size Size of coffee
     * @param extraShot Whether to add extra shot
     * @param extraSyrup Whether to add extra syrup
     */
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) price += 0.5;
        if (extraSyrup) price += 0.5;
        if (getSize() == Size.MEDIUM) price += 0.5;
        return price;
    }

    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    @Override
    public String toString() {
        return super.toString() + "," + extraShot + "," + extraSyrup + "," + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Coffee)) return false;
        Coffee other = (Coffee) obj;
        return this.extraShot == other.extraShot && 
               this.extraSyrup == other.extraSyrup;
    }
}