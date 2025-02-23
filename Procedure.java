/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The Procedure java class is used to gather information about the procedure that was done on the user, the date
 * of the procedure, who the practitioner was, and how much they were charged by it. Constructors are used for the procedure date,
 * name, practitioner name and the charges. Accessors are used to get them, and the mutators are to set them. It then displays the
 * user information.
 * Due: 2/24/2025
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

public class Procedure {
    // Fields
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charges;

    // No-arg constructor
    public Procedure() {}

    // constructor for the procedure name and date of the procedure
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    //  constructor for all parts of the procedure
    public Procedure(String procedureName, String procedureDate, String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    // Accessors
    public String getProcedureName() { return procedureName; }
    public String getProcedureDate() { return procedureDate; }
    public String getPractitionerName() { return practitionerName; }
    public double getCharges() { return charges; }

    // Mutators
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }
    public void setPractitionerName(String practitionerName) { this.practitionerName = practitionerName; }
    public void setCharges(double charges) { this.charges = charges; }

    // Method to display procedure information
    public void displayProcedure() {
        System.out.println("\tProcedure: " + procedureName);
        System.out.println("\tProcedureDate=" + procedureDate);
        System.out.println("\tPractitioner=" + practitionerName);
        System.out.println("\tCharge=" + String.format("%.2f", charges));
    }

    // toString method
    @Override
    public String toString() {
        return "\tProcedure: " + procedureName + "\n" +
               "\tProcedureDate=" + procedureDate + "\n" +
               "\tPractitioner=" + practitionerName + "\n" +
               "\tCharge=" + String.format("%.2f", charges) + "\n";
    }

    // Main method
    public static void main(String[] args) {
        // To terminate the background running thread.
        System.exit(0);
    }
}