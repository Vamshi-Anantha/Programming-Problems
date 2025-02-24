import java.util.Scanner;

public class PrimeNumberSquareRootMethod {
    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        if (isPrime(num))
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
}

// import java.util.Scanner;

// public class PrimeNumberSquareRootMethod {
// static boolean isPrime(int n) {
// if (n < 2)
// return false;

// for (int i = 2; i < n; i++) {
// if (n % i == 0)
// return false;
// }
// return true;
// }

// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.print("Enter a number: ");
// int num = scanner.nextInt();
// scanner.close();
// if (isPrime(num))
// System.out.println(num + " is a prime number.");
// else
// System.out.println(num + " is not a prime number.");
// }
// }
