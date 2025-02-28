import java.util.Arrays;

class Reverse_array { // Class name as per your request
    public static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) { // Loop until the pointers meet or cross
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    // Swap function to exchange values at two indices
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        reverseArray(arr); // Call function to reverse the array

        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
