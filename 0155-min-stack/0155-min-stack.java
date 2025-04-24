class MinStack {

    class Pair{
        int value;
        int min;

        Pair(int v, int m){
            this.value = v;
            this.min   = m;
        }
    }

    Stack<Pair> s;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(new Pair(val,val));
        }else{
            Pair p = new Pair(val, Math.min(s.peek().min,val));
            s.push(p);
        }
        
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().value;
    }
    
    public int getMin() {
        return s.peek().min;
    }
}

// class MinStack {
//     private Stack<Integer> stack;
//     private Stack<Integer> minStack;

//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         stack.push(val);
//         // Push to minStack if it's empty or the new value is smaller or equal to the current min
//         if (minStack.isEmpty() || val <= minStack.peek()) {
//             minStack.push(val);
//         }
//     }
    
//     public void pop() {
//         if (!stack.isEmpty()) {
//             int removed = stack.pop();
//             // If the popped element is the minimum, remove it from minStack as well
//             if (removed == minStack.peek()) {
//                 minStack.pop();
//             }
//         }
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */