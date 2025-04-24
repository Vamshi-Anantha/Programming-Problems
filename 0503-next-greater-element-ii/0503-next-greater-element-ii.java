// 1st method
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] stack = new int[n]; // Using array instead of Stack<Integer> to reduce memory overhead
        int top = -1;

        // Default all elements to -1 (if no greater element is found)
        Arrays.fill(res, -1);

        // Traverse twice to handle circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n]; // Circular array index

            while (top != -1 && nums[stack[top]] < num) {
                res[stack[top--]] = num;
            }

            // Push only first-pass indices to the stack
            if (i < n) {
                stack[++top] = i;
            }
        }

        return res;
    }
}

// 2nd method
// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n = nums.length;
//         int[] result = new int[n];
//         Stack<Integer> stack = new Stack<>();

//         // Initialize result with -1 (default if no greater element is found)
//         Arrays.fill(result, -1);

//         // Traverse the array twice to simulate circular behavior
//         for (int i = 0; i < 2 * n; i++) {
//             int num = nums[i % n]; // Circular array index

//             // Pop elements from the stack if we find a greater element
//             while (!stack.isEmpty() && nums[stack.peek()] < num) {
//                 result[stack.pop()] = num;
//             }

//             // Only push indices from the first pass to avoid redundant work
//             if (i < n) {
//                 stack.push(i);
//             }
//         }

//         return result;
//     }
// }
