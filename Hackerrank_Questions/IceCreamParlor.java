// 2. Ice Cream Parlor (IceCreamParlor.java)
// Problem:
// Given a list of ice cream prices and a budget, find two indices where the sum equals the budget.

// Brute Force Approach (O(n²))
// Check all possible pairs (i, j) and return the first that sums to m.
// Optimized Approach (O(n))
// Use a HashMap to store the price and index.
// For each price, check if m - price exists in the HashMap.
package Hackerrank_Questions;

import java.io.*;
import java.util.*;
import java.util.stream.*;
// import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER m
     * 2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Brute force approach: O(n^2) complexity
        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i) + arr.get(j) == m) {
                    return Arrays.asList(i + 1, j + 1); // Convert to 1-based index
                }
            }
        }

        return new ArrayList<>(); // This won't execute since there's always a solution
    }
}

public class IceCreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); // Fix

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int m = Integer.parseInt(bufferedReader.readLine().trim());
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> result = Result.icecreamParlor(m, arr);

            bufferedWriter.write(result.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")) + "\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
