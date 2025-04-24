class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}


// class MyQueue {
    // Stack<Integer> s1;
    // Stack<Integer> s2;

//     public MyQueue() {
        // s1 = new Stack<>();
        // s2 = new Stack<>();
//     }
    
//     // O(1) time complexity
//     public void push(int x) {
//         s1.push(x);
//     }
    
//     // O(n) time complexity (only when s2 is empty)
//     public int pop() {
//         if (s2.isEmpty()) {
//             while (!s1.isEmpty()) {
//                 s2.push(s1.pop());
//             }
//         }
//         return s2.pop();
//     }
    
//     // O(n) time complexity (only when s2 is empty)
//     public int peek() {
//         if (s2.isEmpty()) {
//             while (!s1.isEmpty()) {
//                 s2.push(s1.pop());
//             }
//         }
//         return s2.peek();
//     }
    
//     // O(1) time complexity
//     public boolean empty() {
//         return s1.isEmpty() && s2.isEmpty();
//     }
// }
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */