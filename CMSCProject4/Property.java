/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: This class models real estate property, having attributes for name, location, rent amount,
 * owner, and plot. Constructors include default values, parameterized options, and copy constructors.
 * Getter methods are included for all attributes and an overridden toString() that formats property data 
 * as "name,city,owner,rent". The class maintains composition with the Plot class to represent the property's 
 * physical dimensions and location.
 * Due: 03/31/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * Represents a Property object with name, location, rent, and plot information.
 */
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    /**
     * Creates a new Property using empty strings and a default Plot.
     */
    public Property() {
        this("", "", 0.0, "", 0, 0, 1, 1);
    }

    /**
     * Creates a new Property object using given values and a default Plot.
     * @param propertyName property name
     * @param city city where the property is located
     * @param rentAmount rent amount
     * @param owner the owner's name
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    /**
     * Creates a new Property object with given values and specified plot dimensions.
     * @param propertyName property name
     * @param city city where the property is located
     * @param rentAmount rent amount
     * @param owner the owner's name
     * @param x the x coordinate of the plot
     * @param y the y coordinate of the plot
     * @param width the width coordinate of the plot
     * @param depth the depth coordinate of the plot
     */
    public Property(String propertyName, String city, double rentAmount, String owner,
                   int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    /**
     * Creates a new copy of the given property object.
     * @param otherProperty the Property object to copy
     */
    public Property(Property otherProperty) {
        this(otherProperty.propertyName, 
             otherProperty.city, 
             otherProperty.rentAmount, 
             otherProperty.owner,
             otherProperty.plot.getX(),
             otherProperty.plot.getY(),
             otherProperty.plot.getWidth(),
             otherProperty.plot.getDepth());
    }

    // Getter methods
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    /**
     * Represents the Property object in String format: "propertyName,city,owner,rentAmount"
     * @return the string representation of the property
     */
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}