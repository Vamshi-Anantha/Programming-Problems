// 1st method
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        
        while (index < asteroids.length) {
            if (stack.isEmpty()) {
                stack.push(asteroids[index]);
                index++;
                continue;
            }

            // Check if there is a collision (opposite directions)
            if (stack.peek() > 0 && asteroids[index] < 0) {
                if (Math.abs(stack.peek()) > Math.abs(asteroids[index])) {
                    // Stack top is larger, current asteroid is destroyed
                    index++;
                } else if (Math.abs(stack.peek()) < Math.abs(asteroids[index])) {
                    // Stack top is destroyed, pop and continue without index++
                    stack.pop();
                } else {
                    // Both asteroids are equal in size, destroy both
                    stack.pop();
                    index++;
                }
            } else {
                // No collision, push to stack
                stack.push(asteroids[index]);
                index++;
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

// 2nd method
// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> stack = new Stack<>();

//         for (int asteroid : asteroids) {
//             boolean isDestroyed = false;

//             while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
//                 int top = stack.pop();

//                 if (top > -asteroid) { // Top asteroid is bigger (survives)
//                     stack.push(top);
//                     isDestroyed = true;
//                     break;
//                 } else if (top == -asteroid) { // Both asteroids destroy each other
//                     isDestroyed = true;
//                     break;
//                 }
//             }

//             if (!isDestroyed) {
//                 stack.push(asteroid);
//             }
//         }

//         int[] result = new int[stack.size()];
//         for (int i = result.length - 1; i >= 0; i--) {
//             result[i] = stack.pop();
//         }
//         return result;
//     }
// }
