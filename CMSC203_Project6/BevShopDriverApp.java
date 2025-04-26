/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The BevShopDriverApp serves as the interactive interface for the beverage shop system, 
 * allowing users to create and manage drink orders through a console-based menu. It demonstrates all 
 * core functionality by guiding users through ordering coffee (with customizations), alcohol 
 * (with age verification), and smoothies (with fruit/protein options) while enforcing business rules 
 * like operating hours and drink limits. The application provides real-time order summaries and generates 
 * final sales reports showing total orders and monthly revenue.
 * Due: 04/26/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/


import java.util.Scanner;

/**
 * Interactive Beverage Shop Driver Application
 */
public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop shop = new BevShop();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Bradley Beverage Shop!");
        System.out.println("Shop Hours: 8am-11pm (Enter time as 8-23)");
        System.out.println("Minimum Age for Alcohol: " + shop.getMinAgeForAlcohol());
        System.out.println("----------------------------------------");
        
        while (true) {
            System.out.println("\nWould you like to start a new order? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();
            
            if (!choice.equals("yes")) {
                break;
            }
            
            System.out.println("Enter order time (8-23):");
            int time = Integer.parseInt(scanner.nextLine());
            
            System.out.println("Enter day (MONDAY-SUNDAY):");
            Day day = Day.valueOf(scanner.nextLine().toUpperCase());
            
            System.out.println("Enter customer name:");
            String name = scanner.nextLine();
            
            System.out.println("Enter customer age:");
            int age = Integer.parseInt(scanner.nextLine());
            
            shop.startNewOrder(time, day, name, age);
            Order current = shop.getCurrentOrder();
            
            if (age >= shop.getMinAgeForAlcohol()) {
                System.out.println("This customer can order alcohol.");
            }
            
            while (true) {
                System.out.println("\nCurrent Order Total: $" + 
                    String.format("%.2f", current.calcOrderTotal()));
                System.out.println("Add beverage (COFFEE/ALCOHOL/SMOOTHIE) or DONE:");
                String beverageType = scanner.nextLine().toUpperCase();
                
                if (beverageType.equals("DONE")) {
                    break;
                }
                
                try {
                    System.out.println("Enter size (SMALL/MEDIUM/LARGE):");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());
                    
                    switch (beverageType) {
                        case "COFFEE":
                            System.out.println("Extra shot? (yes/no)");
                            boolean extraShot = scanner.nextLine().equalsIgnoreCase("yes");
                            System.out.println("Extra syrup? (yes/no)");
                            boolean extraSyrup = scanner.nextLine().equalsIgnoreCase("yes");
                            shop.processCoffeeOrder("Coffee", size, extraShot, extraSyrup);
                            break;
                            
                        case "ALCOHOL":
                            if (age < shop.getMinAgeForAlcohol()) {
                                System.out.println("Order rejected. Customer is underage.");
                                break;
                            }
                            if (!shop.isEligibleForMore()) {
                                System.out.println("Maximum alcohol drinks reached for this order.");
                                break;
                            }
                            shop.processAlcoholOrder("Alcohol", size);
                            System.out.println("Alcohol drinks in order: " + 
                                shop.getNumOfAlcoholDrink() + "/" + shop.getMaxOrderForAlcohol());
                            break;
                            
                        case "SMOOTHIE":
                            System.out.println("Number of fruits (max 5):");
                            int fruits = Integer.parseInt(scanner.nextLine());
                            if (shop.isMaxFruit(fruits)) {
                                System.out.println("Cannot exceed maximum fruits.");
                                break;
                            }
                            System.out.println("Add protein? (yes/no)");
                            boolean protein = scanner.nextLine().equalsIgnoreCase("yes");
                            shop.processSmoothieOrder("Smoothie", size, fruits, protein);
                            break;
                            
                        default:
                            System.out.println("Invalid beverage type.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
            
            System.out.println("\nOrder Complete!");
            System.out.println("Order#: " + current.getOrderNo());
            System.out.println("Customer: " + current.getCustomer());
            System.out.println("Items: " + current.getTotalItems());
            System.out.println("Total: $" + String.format("%.2f", current.calcOrderTotal()));
            System.out.println("----------------------------------------");
        }
        
        System.out.println("\n=== SHOP SUMMARY ===");
        System.out.println("Total Orders Today: " + shop.totalNumOfMonthlyOrders());
        System.out.println("Total Sales: $" + String.format("%.2f", shop.totalMonthlySale()));
        System.out.println("\nThank you for using Bradley Beverage Shop!");
        scanner.close();
    }
}