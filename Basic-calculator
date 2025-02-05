package BasicCalc;
import java.util.Scanner;

public class EnhancedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Logarithm");
            System.out.println("7. Unit Conversion (Miles to Km)");
            System.out.println("8. Power (Exponentiation)");
            System.out.println("9. Trigonometric Functions");
            System.out.println("10. Temperature Conversion (Celsius to Fahrenheit)");
            System.out.println("11. Show Calculation History");
            System.out.println("12. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performBasicOperation(scanner, "add");
                    break;
                case 2:
                    performBasicOperation(scanner, "subtract");
                    break;
                case 3:
                    performBasicOperation(scanner, "multiply");
                    break;
                case 4:
                    performBasicOperation(scanner, "divide");
                    break;
                case 5:
                    performScientificOperation(scanner, "sqrt");
                    break;
                case 6:
                    performScientificOperation(scanner, "log");
                    break;
                case 7:
                    performUnitConversion(scanner);
                    break;
                case 8:
                    performScientificOperation(scanner, "power");
                    break;
                case 9:
                    performTrigonometry(scanner);
                    break;
                case 10:
                    performTemperatureConversion(scanner);
                    break;
                case 11:
                    showHistory();
                    break;
                case 12:
                    continueCalculation = false;
                    System.out.println("Exiting the calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    // Function to perform basic operations like add, subtract, etc.
    public static void performBasicOperation(Scanner scanner, String operation) {
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        double result = 0;
        switch (operation) {
            case "add":
                result = a + b;
                break;
            case "subtract":
                result = a - b;
                break;
            case "multiply":
                result = a * b;
                break;
            case "divide":
                if (b == 0) {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                result = a / b;
                break;
        }
        System.out.println("Result: " + result);
        saveHistory(operation, a, b, result);
    }

    // Function to perform scientific operations like square root, log, and power
    public static void performScientificOperation(Scanner scanner, String operation) {
        System.out.print("Enter number: ");
        double a = scanner.nextDouble();

        double result = 0;
        switch (operation) {
            case "sqrt":
                if (a < 0) {
                    System.out.println("Error: Cannot take square root of negative number.");
                    return;
                }
                result = Math.sqrt(a);
                break;
            case "log":
                if (a <= 0) {
                    System.out.println("Error: Logarithm only defined for positive numbers.");
                    return;
                }
                result = Math.log(a);
                break;
            case "power":
                System.out.print("Enter the exponent: ");
                double exponent = scanner.nextDouble();
                result = Math.pow(a, exponent);
                break;
        }
        System.out.println("Result: " + result);
        saveHistory(operation, a, result, result);
    }

    // Function to handle unit conversion (miles to km)
    public static void performUnitConversion(Scanner scanner) {
        System.out.print("Enter distance in miles: ");
        double miles = scanner.nextDouble();
        double km = miles * 1.60934;
        System.out.println(miles + " miles is " + km + " kilometers.");
        saveHistory("miles to km", miles, km, km);
    }

    // Function to perform trigonometric calculations
    public static void performTrigonometry(Scanner scanner) {
        System.out.println("Select Trigonometric Function:");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");

        int choice = scanner.nextInt();
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        double radians = Math.toRadians(angle); // Convert degrees to radians

        double result = 0;
        switch (choice) {
            case 1:
                result = Math.sin(radians);
                break;
            case 2:
                result = Math.cos(radians);
                break;
            case 3:
                result = Math.tan(radians);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        System.out.println("Result: " + result);
    }

    // Temperature conversion (Celsius to Fahrenheit)
    public static void performTemperatureConversion(Scanner scanner) {
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + "°C is " + fahrenheit + "°F");
    }

    // Function to save calculation history (simplified, can be expanded with a list)
    public static void saveHistory(String operation, double a, double b, double result) {
        // Store history (this can be expanded to actually save history in a list or file)
        System.out.println("Operation: " + operation + " | " + a + " & " + b + " = " + result);
    }

    // Show history (for simplicity, just show a dummy message)
    public static void showHistory() {
        System.out.println("Showing last few calculations...");
        // This could be expanded to show a list of past operations.
    }
}
