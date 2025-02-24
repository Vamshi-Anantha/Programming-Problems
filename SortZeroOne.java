import java.util.Scanner;

public class SortZeroOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int count0 = 0; // Count of zeros

        System.out.println("Enter elements (only 0s and 1s):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                count0++;
            }
        }

        // Fill first count0 elements with 0, rest with 1
        for (int i = 0; i < n; i++) {
            arr[i] = (i < count0) ? 0 : 1;
        }

        // Output sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
