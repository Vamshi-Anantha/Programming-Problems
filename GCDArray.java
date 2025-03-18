import java.util.Arrays;

public class GCDArray {
    // Method to compute GCD of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to compute GCD of an array
    public static int gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) { // Early exit if GCD becomes 1
                return 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 48, 18, 30, 42 };
        System.out.println("GCD of array " + Arrays.toString(arr) + " is: " + gcdOfArray(arr));
    }
}
