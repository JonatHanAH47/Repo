/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The ManagementCompany class manages a portfolio of up to 5 properties 
 * within a 10x10 management plot. It provides functionality to add/remove properties, 
 * validate management fees (0-100%), track property counts, and identify the 
 * highest-rent property. Key methods include addProperty() (with multiple overloads) which 
 * performs validation checks, and getTotalRent() which calculates cumulative rent. The class 
 * also generates comprehensive reports via toString() showing all properties and total management fees.
 * Due: 03/31/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * Represents a property management company
 */
public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    /**
     * Creates a ManagementCompany object using empty strings, creates a default Plot
     */
    public ManagementCompany() {
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }
    
    /**
     * Creates a ManagementCompany object using the given values
     */
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }
    
    /**
     * Creates a ManagementCompany object using the given values creates a Plot
     */
    public ManagementCompany(String name, String taxID, double mgmFee,
                           int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    /**
     * Creates a new ManagementCompany copy of the given ManagementCompany
     */
    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee,
            otherCompany.plot.getX(), otherCompany.plot.getY(),
            otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            if (otherCompany.properties[i] != null) {
                this.properties[i] = new Property(otherCompany.properties[i]);
            }
        }
        this.numberOfProperties = otherCompany.numberOfProperties;
    }

    /**
     * Adds a property to the properties array
     * @return -1 if array is full, -2 if property is null, -3 if not encompassed, -4 if overlaps
     */
    public int addProperty(Property property) {
        if (property == null) return -2;
        if (isPropertiesFull()) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;
        
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null && 
                properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        
        properties[numberOfProperties] = property;
        return numberOfProperties++;
    }
    
    /**
     * Adds a property to the properties array
     */
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }
    
    /**
     * Adds a property to the properties array
     */
    public int addProperty(String name, String city, double rent,
                         String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    /**
     * Gets the property with highest rent
     */
    public Property getHighestRentPropperty() {
        if (numberOfProperties == 0) return null;
        
        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i] != null && 
                properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }
    
    /**
     * Returns the total rent of all properties
     */
    public double getTotalRent() {
        double total = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                total += properties[i].getRentAmount();
            }
        }
        return total;
    }

    /**
     * Checks if properties array is full
     */
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }
    
    /**
     * Checks if management fee is valid (0-100)
     */
    public boolean isMangementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }
    
    /**
     * Gets number of properties
     */
    public int getPropertiesCount() {
        return numberOfProperties;
    }
    
    /**
     * Removes the last property in the array
     */
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[--numberOfProperties] = null;
        }
    }

    /**
     * Represents information of all properties
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID).append("\n")
          .append("______________________________________________________\n");
        
        if (numberOfProperties == 0) {
            sb.append("No Properties\n");
        } else {
            for (int i = 0; i < numberOfProperties; i++) {
                if (properties[i] != null) {
                    sb.append(properties[i].toString()).append("\n");
                }
            }
        }
        
        sb.append("______________________________________________________\n")
          .append("\n")
          .append(String.format(" total management Fee: %.2f", getTotalRent() * mgmFee / 100));
        
        return sb.toString();
    }

    // Getters
    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public double getMgmFeePer() { return mgmFee; }
    public Plot getPlot() { return plot; }
    public Property[] getProperties() { return properties; }
}