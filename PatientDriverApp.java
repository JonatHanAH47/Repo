/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The final part of the project, the Patient Driver App java class, brings everything together. It asks the user to
 * input everything about themselves and the procedures. Names, Address, Contacts, Procedures, etc. It then uses the previous two
 * classes, Patient and Procedure, to display what was user has entered neatly, as well as adding up the charges, to get one total.
 * At the end it displays a closing message by the coder.
 * Due: 2/24/2025
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

import java.util.Scanner;

public class PatientDriverApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input patient details
        System.out.println("Enter patient details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Street Address: ");
        String streetAddress = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("ZIP Code: ");
        String zipCode = scanner.nextLine();
        System.out.print("Emergency Contact Name: ");
        String emergencyContactName = scanner.nextLine();
        System.out.print("Emergency Contact Phone: ");
        String emergencyContactPhone = scanner.nextLine();

        // Patient object
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, emergencyContactName, emergencyContactPhone);

        // Input details for three procedures
        Procedure[] procedures = new Procedure[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Procedure " + (i + 1) + ":");
            System.out.print("Procedure Name: ");
            String procedureName = scanner.nextLine();
            System.out.print("Procedure Date: ");
            String procedureDate = scanner.nextLine();
            System.out.print("Practitioner Name: ");
            String practitionerName = scanner.nextLine();
            System.out.print("Charges: ");
            double charges = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            procedures[i] = new Procedure(procedureName, procedureDate, practitionerName, charges);
        }

        // Display patient information
        System.out.println("\nPatient Information:");
        patient.displayPatient();

        // Display procedure information
        System.out.println("\nProcedure Information:");
        for (Procedure procedure : procedures) {
            procedure.displayProcedure();
        }

        // Calculate and display total charges
        double totalCharges = calculateTotalCharges(procedures[0], procedures[1], procedures[2]);
        System.out.println("\nTotal Charges: $" + String.format("%,.2f", totalCharges));

        // Input student name and date
        System.out.print("\nEnter your name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter today's date: ");
        String date = scanner.nextLine();

        // Display closing message
        System.out.println("\nThe program was developed by a Student: " + studentName + " " + date);

        scanner.close();

        // To terminate the background running thread.
        System.exit(0);
    }

    // Method to calculate total charges
    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
        return procedure1.getCharges() + procedure2.getCharges() + procedure3.getCharges();
    }
}