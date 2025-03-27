// import java.util.*;

// class LinkedStack {
//     static class Node {
//         int data;
//         Node next;

//         Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     static class Stack {
//         Node top;

//         Stack() {
//             this.top = null;
//         }

//         // Push element onto stack
//         void push(int element) {
//             Node newNode = new Node(element);
//             newNode.next = top;
//             top = newNode;
//         }

//         // Peek top element
//         int peek() {
//             if (top == null) {
//                 return -1;
//             }
//             return top.data;
//         }

//         // Pop element from stack
//         int pop() {
//             if (top == null) {
//                 return -1;
//             }
//             int element = top.data;
//             top = top.next;
//             return element;
//         }

//         // Check if stack is empty
//         boolean isEmpty() {
//             return top == null;
//         }

//         // Print stack elements
//         void printStack() {
//             if (top == null) {
//                 System.out.println("Stack is empty");
//                 return;
//             }
//             System.out.println("Stack elements (top to bottom):");
//             Node temp = top;
//             while (temp != null) {
//                 System.out.println(temp.data);
//                 temp = temp.next;
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Stack s = new Stack();
//         s.push(10);
//         s.push(20);
//         s.push(30);
//         s.push(40);
//         s.push(50);

//         // Print stack before popping
//         s.printStack();

//         System.out.println("\nPeek: " + s.peek());

//         System.out.println("\nPopping elements:");
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());

//         // Print stack after popping
//         System.out.println("\nStack after popping:");
//         s.printStack();
//     }
// }

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

    Node top;
    int size;

    LinkedStack() {
        top = null;
        size = 0;
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    int pop() {
        if (top == null)
            return -1;
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    int peek() {
        return top != null ? top.data : -1;
    }

    void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            push(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = top;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    int getIndex(int index) {
        if (index < 0 || index >= size)
            return -1;
        Node temp = top;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    int getFront() {
        return peek();
    }

    int getTail() {
        Node temp = top;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        return temp != null ? temp.data : -1;
    }

    void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            pop();
            return;
        }
        Node temp = top;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.addAtIndex(1, 15);
        stack.printStack();
    }
}
