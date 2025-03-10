import java.util.*;

public class BubbleSort {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size: ");
        int a = s.nextInt();

        int[] arr = new int[a];

        System.out.println("Enter elements: ");
        for (int i = 0; i < a; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < a - 1; i++) {
            for (int j = 0; j < a - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        printArray(arr);
        s.close();
    }
}
