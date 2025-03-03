import java.util.Scanner;

class RepeatedCharacter {
    public char repeatedCharacter(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return s.charAt(i);
                }
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        RepeatedCharacter obj = new RepeatedCharacter();
        System.out.println("First repeated character: " + obj.repeatedCharacter(input));
    }
}

// optimised approach

// class Solution {
// public char repeatedCharacter(String s) {
// int[] freq = new int[26];

// for(int i = 0; i < s.length(); i++){
// char c = s.charAt(i);
// int index = c - 97;
// if(freq[index]!= 0){
// return s.charAt(i);
// }else{
// freq[index]++;
// }

// }
// return ' ';
// }
// }