// Brute Force Approach (O(n²))
// The brute force solution checks all substrings and verifies if they have unique characters.
public class LongestUniqueSubstringBruteForce {
    public static int longestUniqueSubstr(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256]; // To track character occurrences
            for (int j = i; j < n; j++) {
                if (visited[s.charAt(j)]) {
                    break; // Stop when a duplicate is found
                }
                visited[s.charAt(j)] = true;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest Unique Substring Length (Brute Force): " + longestUniqueSubstr(s));
    }
}

// ------------------
// import java.util.Scanner;

// public class LongestUniqueSubstringBruteForce {
// public static int longestUniqueSubstr(String s) {
// int n = s.length();
// int maxLength = 0;

// for (int i = 0; i < n; i++) {
// boolean[] visited = new boolean[256]; // Track characters
// for (int j = i; j < n; j++) {
// if (visited[s.charAt(j)]) {
// break; // Stop when a duplicate is found
// }
// visited[s.charAt(j)] = true;
// maxLength = Math.max(maxLength, j - i + 1);
// }
// }
// return maxLength;
// }

// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.print("Enter a string: ");
// String input = scanner.nextLine();
// scanner.close();

// System.out.println("Longest Unique Substring Length (Brute Force): " +
// longestUniqueSubstr(input));
// }
// }

// -------------------

// Optimal Approach: Sliding Window (O(n))
// We use the Sliding Window + HashSet to efficiently track unique characters.

// import java.util.HashSet;

// public class LongestUniqueSubstring {
// public static int longestUniqueSubstr(String s) {
// int n = s.length();
// int maxLength = 0;
// int left = 0;
// HashSet<Character> set = new HashSet<>();

// for (int right = 0; right < n; right++) {
// while (set.contains(s.charAt(right))) {
// set.remove(s.charAt(left));
// left++;
// }
// set.add(s.charAt(right));
// maxLength = Math.max(maxLength, right - left + 1);
// }

// return maxLength;
// }

// public static void main(String[] args) {
// String s = "abcabcbb";
// System.out.println("Longest Unique Substring Length: " +
// longestUniqueSubstr(s));
// }
// }
