import java.util.*;

public class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int element) {
        q2.add(element);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.poll();
    }

    public int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack peek: " + stack.peek());
    }
}

// class MyStack {
// Queue<Integer>q1;
// Queue<Integer>q2;

// public MyStack() {
// q1 = new LinkedList<>();
// q2 = new LinkedList<>();

// }
// // O(n) time
// public void push(int x) {
// if(q1.isEmpty()){
// q1.add(x);
// }else{
// q2.add(x);
// while(!q1.isEmpty()){
// q2.add(q1.remove());
// }
// Queue<Integer> q = q1;
// q1 = q2;
// q2 = q;

// }

// }

// public int pop() {
// return q1.remove();

// }

// public int top() {
// return q1.peek();

// }

// public boolean empty() {
// return q1.isEmpty();

// }
// }

// /**
// * Your MyStack object will be instantiated and called as such:
// * MyStack obj = new MyStack();
// * obj.push(x);
// * int param_2 = obj.pop();
// * int param_3 = obj.top();
// * boolean param_4 = obj.empty();
// */