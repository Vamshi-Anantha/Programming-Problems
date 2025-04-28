class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the result is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];  // Maximum possible length of the result

        // Perform the multiplication (long multiplication)
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add to the existing value at position

                result[i + j + 1] = sum % 10; // Set the current position with the unit digit
                result[i + j] += sum / 10;    // Carry over the tens to the next position
            }
        }

        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
