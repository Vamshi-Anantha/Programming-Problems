import java.util.Scanner;

public class LargestAndSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == -1) {
            System.out.println("No second largest element exists.");
        } else {
            System.out.println("Largest element: " + largest);
            System.out.println("Second Largest element: " + secondLargest);
        }

        sc.close();
    }
}
