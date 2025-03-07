import java.util.ArrayList;

public class RabinKarp {
    static final int MOD = 1000000007;
    static final int P = 998857; // Base for hashing

    public static ArrayList<Integer> search(String pattern, String text) {
        int N = text.length(); // Length of the text
        int M = pattern.length(); // Length of the pattern
        long d = 1;
        long targetHashValue = 0;
        long rollingHashValue = 0;
        ArrayList<Integer> list = new ArrayList<>();

        if (M > N)
            return list; // If pattern is longer than text, return empty list

        // Precompute the hash values for the pattern and the first M characters of the
        // text
        for (int i = 0; i < M; i++) {
            targetHashValue = (targetHashValue * P + pattern.charAt(i)) % MOD;
            rollingHashValue = (rollingHashValue * P + text.charAt(i)) % MOD;
            if (i > 0)
                d = (d * P) % MOD; // Precompute P^(M-1) % MOD
        }

        // Sliding window to check for pattern occurrences
        for (int i = 0; i + M <= N; i++) {
            // If hash values match, add index to list (collision probability is low)
            if (targetHashValue == rollingHashValue) {
                list.add(i + 1); // Storing 1-based index
            }

            // Update rolling hash (remove leading char and add next char)
            if (i + M < N) {
                rollingHashValue = (rollingHashValue * P + text.charAt(i + M) - text.charAt(i) * d) % MOD;
                if (rollingHashValue < 0)
                    rollingHashValue += MOD; // Ensure non-negative hash
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String text = "abcabcabc";
        String pattern = "abc";
        ArrayList<Integer> result = search(pattern, text);

        System.out.println("Pattern found at positions: " + result);
    }
}
