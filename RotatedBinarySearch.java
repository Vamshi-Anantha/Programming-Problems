import java.util.*;

class RotatedBinarySearch {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int N = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the middle element is the target, return its index
            if (arr[mid] == target) {
                return mid;
            }

            // Check if we are in the right part of the pivot
            if (arr[mid] < arr[0]) {
                if (arr[mid] <= target && target <= arr[N - 1]) {
                    low = mid + 1; // Move right
                } else {
                    high = mid - 1; // Move left
                }
            } else { // We are in the left part of the pivot
                if (arr[0] <= target && target <= arr[mid]) {
                    high = mid - 1; // Move left
                } else {
                    low = mid + 1; // Move right
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        RotatedBinarySearch searchObj = new RotatedBinarySearch();
        int result = searchObj.search(arr, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}
