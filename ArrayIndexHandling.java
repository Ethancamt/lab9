import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayIndexHandling {
    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill array with random integers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        while (true) {
            System.out.print("Please enter index of array(0 - 99): ");
            try {
                int index = scanner.nextInt();
                System.out.println("The value at index " + index + " is " + array[index] + ".");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You refer to an index that does not exist.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
            System.out.println("Continuing processing ...");
        }
    }
}
