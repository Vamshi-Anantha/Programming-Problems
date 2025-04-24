// 1st method
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int index = s.pop();
                ans[index] = i - index;
            }
            s.push(i); // Push current index AFTER handling the warmer temperature check
        }
        
        return ans; // Return result after processing all elements
    }
}

// 2nd method
// class Solution {

//     static {
//         for (int i = 0; i < 500; i++) {
//             dailyTemperatures(new int[] {});
//         }
//     }

//     public static int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//        int[] stack = new int[n];
//        int top = -1;
//        int[] result = new int[n];

//        for(int i=0; i<temperatures.length; i++)
//        {
//             while( top > -1 && temperatures[i] > temperatures[stack[top]])
//             {
//                 int last = stack[top--];
//                 result[last] = i - last;

//             }
//             stack[++top] = i;
//        }
//     return result;
//     }
// }
// 3rd method
// import java.util.Stack;

// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
        // int[] answer = new int[n]; // Result array, initialized to 0
        // Stack<Integer> stack = new Stack<>(); // Stack stores indices

//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//                 int prevIndex = stack.pop(); // Get previous day's index
//                 answer[prevIndex] = i - prevIndex; // Calculate wait time
//             }
//             stack.push(i); // Store the current day's index
//         }
//         return answer;
//     }
// }
