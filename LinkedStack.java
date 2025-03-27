import java.util.*;

class LinkedStack {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        Node top;

        Stack() {
            this.top = null;
        }

        // Push element onto stack
        void push(int element) {
            Node newNode = new Node(element);
            newNode.next = top;
            top = newNode;
        }

        // Peek top element
        int peek() {
            if (top == null) {
                return -1;
            }
            return top.data;
        }

        // Pop element from stack
        int pop() {
            if (top == null) {
                return -1;
            }
            int element = top.data;
            top = top.next;
            return element;
        }

        // Check if stack is empty
        boolean isEmpty() {
            return top == null;
        }

        // Print stack elements
        void printStack() {
            if (top == null) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.println("Stack elements (top to bottom):");
            Node temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        // Print stack before popping
        s.printStack();

        System.out.println("\nPeek: " + s.peek());

        System.out.println("\nPopping elements:");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        // Print stack after popping
        System.out.println("\nStack after popping:");
        s.printStack();
    }
}
