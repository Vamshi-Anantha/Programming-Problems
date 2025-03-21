// The simplest way is to check all possible subarrays and see if any of them sum up to targetSum.
public class SubarraySumBruteForce {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        int targetSum = 12;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += array[j];
                if (currentSum == targetSum) {
                    System.out.println("Subarray found from index " + i + " to " + j);
                    return;
                }
            }
        }
        System.out.println("No subarray found with the target sum.");
    }
}

// -------------------------------
// import java.util.Scanner;

// public class SubarraySumBruteForce {
// public static void findSubarray(int[] array, int targetSum) {
// int n = array.length;

// for (int i = 0; i < n; i++) {
// int currentSum = 0;
// for (int j = i; j < n; j++) {
// currentSum += array[j];
// if (currentSum == targetSum) {
// System.out.println("Subarray found from index " + i + " to " + j);
// return;
// }
// }
// }
// System.out.println("No subarray found with the target sum.");
// }

// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);

// System.out.print("Enter array size: ");
// int n = scanner.nextInt();
// int[] array = new int[n];

// System.out.println("Enter array elements:");
// for (int i = 0; i < n; i++) {
// array[i] = scanner.nextInt();
// }

// System.out.print("Enter target sum: ");
// int targetSum = scanner.nextInt();
// scanner.close();

// findSubarray(array, targetSum);
// }
// }

// ---------------------------------

// Optimized Approach: Sliding Window (O(n))

// public class SubarraySumOptimized {
// public static void main(String[] args) {
// int[] array = {1, 2, 3, 4, 5};
// int targetSum = 12;
// int n = array.length;

// int currentSum = 0;
// int i = 0;

// for (int j = 0; j < n; j++) {
// currentSum += array[j];

// // Shrink the window if the sum exceeds targetSum
// while (currentSum > targetSum && i <= j) {
// currentSum -= array[i];
// i++;
// }

// // Check if we found the target sum
// if (currentSum == targetSum) {
// System.out.println("Subarray found from index " + i + " to " + j);
// return;
// }
// }
// System.out.println("No subarray found with the target sum.");
// }
// }
