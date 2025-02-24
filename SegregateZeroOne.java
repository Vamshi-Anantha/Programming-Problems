public class SegregateZeroOne {
    public static void segregate(int[] arr) {
        int count0 = 0, count1 = 0;

        // Count the number of 0s and 1s manually
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++; // Count zeros
            } else {
                count1++; // Count ones
            }
        }

        // Fill the array with 0s first
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        // Fill the rest with 1s
        for (int i = count0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 0, 1, 0, 1, 0 };

        segregate(arr);

        // Print the sorted array without using built-in functions
        System.out.print("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
