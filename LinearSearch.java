import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size: ");

        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println("Enter target: ");
        int target = s.nextInt();

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                // System.out.print(i);
                index = i;
                break;
            }
        }
        System.out.println(index);
        s.close();

    }

}
