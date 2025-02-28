import java.util.Scanner;

public class CheckSorted {
    public static boolean isSorted(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (isSorted(arr, n)) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not Sorted");
        }

        sc.close();
    }
}
