import java.util.Scanner;

public class Subarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array: ");

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum1 = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            sum1 += arr[i];

            for (int j = i; j < n; j++) {
                sum += arr[j];
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println("-->Sum is : " + sum);

            }

        }
        System.out.println("Sum1 is : " + sum1);
        sc.close();
    }

}
