import java.util.Scanner;

public class FibonacciIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Fibonacci Sequence up to " + n + " terms:");
        fibonacci(n);
    }

    static void fibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        long first = 0, second = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");

            // Compute the next term
            long next = first + second;
            first = second;
            second = next;
        }
    }
}
