import java.util.*;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size:  ");
        int a = s.nextInt();
        int[] arr = new int[a];
        System.out.println("Enter elements: ");
        for (int i = 0; i < a; i++) { // Read elements properly
            arr[i] = s.nextInt();
        }
        for (int i = 0; i < a - 1; i++) {
            int min_ind = i;
            for (int j = i + 1; j < a; j++) {
                if (arr[j] < arr[min_ind]) {
                    min_ind = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;
        }
        System.out.println(Arrays.toString(arr));
        s.close();
    }

}
