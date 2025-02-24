import java.util.Scanner;

public class TwinPrimesFinder {

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false; // Even numbers (except 2) are not prime

        for (int i = 3; i * i <= num; i += 2) { // Check only odd numbers
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to find and print 3 twin primes after m
    public static void findTwinPrimes(int m) {
        int count = 0;
        int num = m + 1; // Start searching from m+1

        while (count < 3) { // Find 3 twin prime pairs
            if (isPrime(num) && isPrime(num + 2)) { // Check if num and (num+2) are prime
                System.out.println("(" + num + ", " + (num + 2) + ")");
                count++;
            }
            num++; // Check the next number
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        int m = scanner.nextInt();

        System.out.println("Next 3 twin prime pairs greater than " + m + " are:");
        findTwinPrimes(m);

        scanner.close();
    }
}
