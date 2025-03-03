public class FirstRepeatingCharacter {
    public static int findFirstRepeatingChar(String str) {
        int n = str.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return str.charAt(i);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "abccbaacz";
        int a = findFirstRepeatingChar(input);

        System.out.println(a != -1 ? "First repeating character: " + (char) a : "-1");
    }
}
