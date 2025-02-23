/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The Patient java class is used to gather all the information about the patient. Constructors are used to 
 * create patient objects, getters and setters methods, and helper methods. This class uses all of these in order to ask the
 * user for their name, address, emergency contact name and number.
 * Due: 2/24/2025
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

public class Patient {
    // Fields
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // No-arg constructor
    public Patient() {}

    // Constructor to get the name of the user
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Constructor for all parts of the patient
    public Patient(String firstName, String middleName, String lastName, String streetAddress, String city, String state, String zipCode, String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Accessors
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getEmergencyContactName() { return emergencyContactName; }
    public String getEmergencyContactPhone() { return emergencyContactPhone; }

    // Mutators
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setEmergencyContactName(String emergencyContactName) { this.emergencyContactName = emergencyContactName; }
    public void setEmergencyContactPhone(String emergencyContactPhone) { this.emergencyContactPhone = emergencyContactPhone; }

    // Method to build full name
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Method to build address
    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    // Method to build emergency contact
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    // Method to display patient information
    public void displayPatient() {
        System.out.println("Patient Info:");
        System.out.println("  Name: " + buildFullName());
        System.out.println("  Address: " + buildAddress());
        System.out.println("  Emergency Contact: " + buildEmergencyContact());
    }

    // toString method
    @Override
    public String toString() {
        return "Patient Info:\n" +
               "  Name: " + buildFullName() + "\n" +
               "  Address: " + buildAddress() + "\n" +
               "  Emergency Contact: " + buildEmergencyContact() + "\n";
    }

    // Main method
    public static void main(String[] args) {
        // To terminate the background running thread.
        System.exit(0);
    }
}