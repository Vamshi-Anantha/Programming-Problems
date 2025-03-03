
// Take a large number input and repeteadly add its digits , take int but not array , example:1369->1+3+6+9=19->1+9=10->1+0=1,till summis 0-9,
import java.util.Scanner;

public class DigitSumReducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a large number: ");
        int num = scanner.nextInt();
        scanner.close();

        System.out.println("Final single-digit sum: " + reduceToSingleDigit(num));
    }

    public static int reduceToSingleDigit(int num) {
        while (num >= 10) { // Continue until num is a single digit
            int sum = 0;
            while (num > 0) {
                sum += num % 10; // Extract last digit and add to sum
                num /= 10; // Remove last digit
            }
            num = sum; // Assign sum to num for next iteration
        }
        return num;
    }
}