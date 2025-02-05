package JavaProject;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ATM Simulator Program
 * Simulates basic ATM operations: PIN validation, balance checks, and cash withdrawals.
 * Uses BigDecimal for precise currency calculations and includes error handling.
 */
public class ATMSimulator {

    // Constants for simulation (in a real system, these would come from a database)
    private static final String CORRECT_PIN = "1234";      // Predefined user PIN
    private static BigDecimal balance = new BigDecimal("1000.00");  // Account balance
    private static final BigDecimal ATM_CASH_LIMIT = new BigDecimal("5000.00"); // Max ATM withdrawal limit

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false;
        int pinAttempts = 0;

        // --------------------------
        // PIN Validation Block
        // --------------------------
        System.out.println("Welcome to the ATM!");
        do {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.nextLine();
            
            if (enteredPin.equals(CORRECT_PIN)) {
                isAuthenticated = true;
                break;  // Exit loop if PIN is correct
            } else {
                pinAttempts++;
                System.out.println("Invalid PIN. Attempts left: " + (3 - pinAttempts));
            }
        } while (pinAttempts < 3);  // Allow up to 3 attempts

        // Check if authentication failed
        if (!isAuthenticated) {
            System.out.println("Too many incorrect attempts. ATM locked.");
            scanner.close();
            return;  // Terminate program
        }

        // --------------------------
        // Main ATM Menu Loop
        // --------------------------
        boolean exit = false;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left by nextInt()

                switch (choice) {
                    case 1 -> checkBalance();        // Display balance
                    case 2 -> withdrawCash(scanner); // Handle withdrawal
                    case 3 -> exit = true;           // Exit ATM
                    default -> System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                // Handle non-integer inputs
                System.out.println("Invalid input! Please enter a number (1-3).");
                scanner.nextLine();  // Clear invalid input from buffer
            }
        } while (!exit);

        // Cleanup and exit
        System.out.println("Thank you for using the ATM!");
        scanner.close();
    }

    /**
     * Displays the current account balance.
     * Uses printf for proper currency formatting.
     */
    private static void checkBalance() {
        System.out.printf("Current Balance: $%.2f%n", balance);
    }

    /**
     * Handles cash withdrawal logic with validation.
     * @param scanner The Scanner object for user input
     */
    private static void withdrawCash(Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");
        
        try {
            BigDecimal amount = scanner.nextBigDecimal();
            scanner.nextLine();  // Consume newline left by nextBigDecimal()

            // --------------------------
            // Withdrawal Validation Checks
            // --------------------------
            // Check 1: Amount must be positive
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Error: Amount must be greater than $0.00.");
            
            // Check 2: Sufficient account balance
            } else if (amount.compareTo(balance) > 0) {
                System.out.println("Error: Insufficient funds in account.");
            
            // Check 3: ATM cash limit
            } else if (amount.compareTo(ATM_CASH_LIMIT) > 0) {
                System.out.println("Error: Exceeds ATM withdrawal limit ($" + ATM_CASH_LIMIT + ").");
            
            // All checks passed - process withdrawal
            } else {
                balance = balance.subtract(amount);
                System.out.printf("Dispensing $%.2f. New balance: $%.2f%n", amount, balance);
            }
        } catch (InputMismatchException e) {
            // Handle non-numeric input
            System.out.println("Error: Invalid amount format. Please enter numbers only (e.g., 100.50).");
            scanner.nextLine();  // Clear invalid input from buffer
        }
    }
}