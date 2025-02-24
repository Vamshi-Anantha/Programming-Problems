import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int avg = sum / arr.length;

        System.out.println("Maximum element in the array: " + max);
        System.out.println("Minimum element in the array: " + min);
        System.out.println("Sum of the elements in the array: " + sum);
        System.out.println("Average of the elements in the array: " + avg);

        sc.close();
    }
}
