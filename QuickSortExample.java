import java.util.Arrays;

public class QuickSortExample {

    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Partition and get pivot index
            quickSort(arr, low, pivotIndex - 1); // Recursively sort left sub-array
            quickSort(arr, pivotIndex + 1, high); // Recursively sort right sub-array
        }
    }

    // Partition function
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the pivot element (last element)
        int count = low; // Start count from low index

        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) { // If current element is smaller than pivot
                swap(arr, i, count); // Swap with count index
                count++; // Move count ahead
            }
        }

        swap(arr, count, high); // Swap pivot element with count (right place for pivot)
        return count; // Return the partition index
    }

    // Swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test the sorting
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
