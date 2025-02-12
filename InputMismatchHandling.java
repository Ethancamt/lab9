import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0, num2 = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter first integer: ");
                num1 = scanner.nextInt();
                System.out.print("Enter second integer: ");
                num2 = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                scanner.next(); // Clear the invalid input
            }
        }
        
        System.out.println("The number entered is " + (num1 + num2));
        scanner.close();
    }
}

