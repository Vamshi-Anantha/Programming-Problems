// 1st method
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0"; 

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        int start = 0;
        while (start < stack.length() && stack.charAt(start) == '0') {
            start++;
        }

        String result = stack.substring(start);
        return result.isEmpty() ? "0" : result;
    }
}

// 2nd method
// class Solution {
//     public String removeKdigits(String num, int k) {
//         int n = num.length();
//         if (k == n) return "0"; 

//         StringBuilder stack = new StringBuilder();

//         for (char digit : num.toCharArray()) {
//             while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > digit) {
//                 stack.deleteCharAt(stack.length() - 1);
//                 k--;
//             }
//             stack.append(digit); 
//         }

//         while (k > 0 && stack.length() > 0) {
//             stack.deleteCharAt(stack.length() - 1);
//             k--;
//         }

//         int start = 0;
//         while (start < stack.length() && stack.charAt(start) == '0') {
//             start++;
//         }

//         String result = stack.substring(start);
//         return result.isEmpty() ? "0" : result;
//     }
// }

// 3rd method
// class Solution {
//     public String removeKdigits(String num, int k) {
//         if(num.length() == k) return "0";

//         Stack<Character> stack = new Stack<>();

//         for(char digit : num.toCharArray()){
//             while((!stack.isEmpty() && k > 0 && stack.peek() > digit)){
//                 stack.pop();
//                 k--;
//             }
//             stack.push(digit);
//         }

//         while(k > 0 && !stack.isEmpty()){
//             stack.pop();
//             k--;
//         }

//         StringBuilder result = new StringBuilder();
//         for(char digit : stack){
//             result.append(digit);
//         }

//         while(result.length() > 0 && result.charAt(0) == '0'){
//             result.deleteCharAt(0);
//         }

//         return result.length() == 0 ? "0" : result.toString();
//     }
// }