// 1. Closest Numbers (ClosestNumbers.java)
// Problem:
// Given an array of integers, find the pairs with the smallest absolute difference.

// Brute Force Approach (O(n²))
// Compare every pair of numbers and find the minimum difference.
// Inefficient for large n.
// Optimized Approach (O(n log n))
// Sort the array.
// Check adjacent elements for the smallest difference.
// More efficient since sorting is O(n log n), and the comparison is O(n).
package Hackerrank_Questions;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class ClosestNumbers {

    /*
     * Optimized function to find closest numbers.
     * Sorts the array and checks adjacent elements.
     */
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.size(); i++) {
            int diff = arr.get(i) - arr.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
            }
            if (diff == minDiff) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = closestNumbers(arr);
        System.out.println(result.stream().map(Object::toString).collect(Collectors.joining(" ")));

        bufferedReader.close();
    }
}
