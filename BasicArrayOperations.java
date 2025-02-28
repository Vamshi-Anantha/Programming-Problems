import java.util.Scanner;

public class BasicArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Reverse the array
        System.out.print("Reversed Array: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Check if the array is sorted
        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            System.out.println("Array is sorted.");
        } else {
            System.out.println("Array is NOT sorted.");
        }

        // Find the largest and second largest element
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element.");
        } else {
            System.out.println("Second Largest Element: " + secondLargest);

        }

        sc.close();
    }
}
