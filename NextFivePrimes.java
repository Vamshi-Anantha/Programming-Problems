// import java.util.Scanner;

// public class NextFivePrimes {
//     public static boolean isPrime(int num) {
//         if (num < 2)
//             return false;
//         if (num == 2)
//             return true;
//         if (num % 2 == 0)
//             return false;
//         for (int i = 3; i * i <= num; i += 2) {
//             if (num % i == 0)
//                 return false;
//         }
//         return true;
//     }

//     public static void findNextFivePrimes(int n) {
//         int count = 0, num = n + 1;
//         while (count < 5) {
//             if (isPrime(num)) {
//                 System.out.print(num + " ");
//                 count++;
//             }
//             num++;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n = scanner.nextInt();
//         System.out.println("Next 5 prime numbers greater than " + n + " are:");
//         findNextFivePrimes(n);
//         scanner.close();
//     }
// }

// import java.util.Scanner;

// public class NextFivePrimes {
//     public static boolean isPrime(int num) {
//         if (num < 2)
//             return false;
//         if (num == 2)
//             return true;
//         if (num % 2 == 0)
//             return false;
//         for (int i = 3; i * i <= num; i += 2) {
//             if (num % i == 0)
//                 return false;
//         }
//         return true;
//     }

//     public static void findNextFivePrimes(int n) {
//         int count = 0, num = n + 1;
//         while (true) {  // Infinite loop, breaks when count reaches 5
//             if (isPrime(num)) {
//                 System.out.print(num + " ");
//                 count++;
//             }
//             if (count == 5)  // Stop searching when 5 primes are found
//                 break;
//             num++;
//         }
//         System.out.println(); // Move to the next line after printing 5 primes
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         while (true) { // Infinite loop to keep asking for input
//             System.out.print("Enter a number (or type -1 to exit): ");
//             int n = scanner.nextInt();

//             if (n == -1) {
//                 System.out.println("Exiting the program. Goodbye!");
//                 break; // Exit the loop when -1 is entered
//             }

//             System.out.println("Next 5 prime numbers greater than " + n + " are:");
//             findNextFivePrimes(n);
//         }

//         scanner.close();
//     }
// }

import java.util.Scanner;

public class NextFivePrimes {
    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void findNextFivePrimes(int n) {
        int count = 0, num = n + 1;
        while (count < 5) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println(); // Move to the next line after printing 5 primes
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Infinite loop to keep asking for input
            System.out.print("Enter a number (or type -1 to exit): ");
            int n = scanner.nextInt();

            if (n == -1) {
                System.out.println("Exiting the program. Goodbye!");
                break; // Exit the loop when -1 is entered
            }

            System.out.println("Next 5 prime numbers greater than " + n + " are:");
            findNextFivePrimes(n);
        }

        scanner.close();
    }
}