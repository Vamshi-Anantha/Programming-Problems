public class SegregateZeroOneTwo {
    public static void segregate(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int index = 0;

        for (int i = 0; i < count0; i++) {
            arr[index++] = 0;
        }

        for (int i = 0; i < count1; i++) {
            arr[index++] = 1;
        }

        for (int i = 0; i < count2; i++) {
            arr[index++] = 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 1, 2, 1, 0, 0, 1, 2 };

        segregate(arr);

        System.out.print("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// public class SegregateZeroOneTwo {
// public static void segregate(int[] arr) {
// int low = 0, mid = 0, high = arr.length - 1;

// while (mid <= high) {
// if (arr[mid] == 0) {
// // Swap arr[low] and arr[mid]
// int temp = arr[low];
// arr[low] = arr[mid];
// arr[mid] = temp;
// low++;
// mid++;
// } else if (arr[mid] == 1) {
// mid++; // Move to the next element
// } else { // arr[mid] == 2
// // Swap arr[mid] and arr[high]
// int temp = arr[mid];
// arr[mid] = arr[high];
// arr[high] = temp;
// high--;
// }
// }
// }

// public static void main(String[] args) {
// int[] arr = {2, 0, 1, 2, 1, 0, 0, 1, 2};

// segregate(arr);

// // Print the sorted array without built-in functions
// System.out.print("Sorted array: ");
// for (int i = 0; i < arr.length; i++) {
// System.out.print(arr[i] + " ");
// }
// }
// }
