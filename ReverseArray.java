import java.util.Arrays;

class ReverseArray {
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Swap arr[left] and arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move the pointers
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println("Original Array: " + Arrays.toString(arr));
        reverseArray(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
