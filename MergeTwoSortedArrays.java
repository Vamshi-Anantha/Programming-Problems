import java.util.Arrays;

class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 3, 5, 6, 7 };

        int k = arr1.length + arr2.length;
        int[] mergedArray = new int[k];

        int i = 0, j = 0, index = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[index++] = arr1[i++];
            } else {
                mergedArray[index++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            mergedArray[index++] = arr1[i++];
        }

        while (j < arr2.length) {
            mergedArray[index++] = arr2[j++];
        }

        System.out.println(Arrays.toString(mergedArray));
    }
}
