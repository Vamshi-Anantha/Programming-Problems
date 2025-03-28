import java.util.*;

public class QueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(int element) {
        s1.push(element);
    }

    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue peek: " + queue.peek());
    }
}

// class MyQueue {
// Stack<Integer> s1;
// Stack<Integer> s2;

// public MyQueue() {
// s1 = new Stack<>();
// s2 = new Stack<>();
// }

// public void push(int x) {
// while(!s1.isEmpty()){
// s2.push(s1.pop());
// }
// s1.push(x);

// while(!s2.isEmpty()){
// s1.push(s2.pop());
// }

// }

// public int pop() {
// return s1.pop();
// }

// public int peek() {
// return s1.peek();
// }

// public boolean empty() {
// return s1.isEmpty();
// }
// }