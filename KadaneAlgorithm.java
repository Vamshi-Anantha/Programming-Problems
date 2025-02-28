import java.util.Scanner;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max_sum = 0, curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            max_sum = Math.max(max_sum, curr_sum);
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        System.out.println(max_sum);
    }
}
