// import java.util.*;

// class LinkedQueue {
//     static class Node {
//         int data;
//         Node next;

//         Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     static class Queue {
//         Node front, rear;

//         Queue() {
//             this.front = this.rear = null;
//         }

//         // Enqueue element to queue
//         void enqueue(int element) {
//             Node newNode = new Node(element);
//             if (rear == null) {
//                 front = rear = newNode;
//                 return;
//             }
//             rear.next = newNode;
//             rear = newNode;
//         }

//         // Peek front element
//         int peek() {
//             if (front == null) {
//                 return -1;
//             }
//             return front.data;
//         }

//         // Dequeue element from queue
//         int dequeue() {
//             if (front == null) {
//                 return -1;
//             }
//             int element = front.data;
//             front = front.next;
//             if (front == null) {
//                 rear = null;
//             }
//             return element;
//         }

//         // Check if queue is empty
//         boolean isEmpty() {
//             return front == null;
//         }

//         // Print queue elements
//         void printQueue() {
//             if (front == null) {
//                 System.out.println("Queue is empty");
//                 return;
//             }
//             System.out.println("Queue elements (front to rear):");
//             Node temp = front;
//             while (temp != null) {
//                 System.out.print(temp.data + " ");
//                 temp = temp.next;
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         Queue q = new Queue();
//         q.enqueue(10);
//         q.enqueue(20);
//         q.enqueue(30);
//         q.enqueue(40);
//         q.enqueue(50);

//         // Print queue before dequeuing
//         q.printQueue();

//         System.out.println("\nPeek: " + q.peek());

//         System.out.println("\nDequeuing elements:");
//         System.out.println(q.dequeue());
//         System.out.println(q.dequeue());
//         System.out.println(q.dequeue());

//         // Print queue after dequeuing
//         System.out.println("\nQueue after dequeuing:");
//         q.printQueue();
//     }
// }

import java.util.*;

class LinkedQueue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear;
    int size;

    LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    int dequeue() {
        if (front == null)
            return -1;
        int val = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        size--;
        return val;
    }

    int peek() {
        return front != null ? front.data : -1;
    }

    void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = front;
            front = newNode;
            return;
        }
        Node temp = front;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    int getFront() {
        return peek();
    }

    int getTail() {
        return rear != null ? rear.data : -1;
    }

    void printQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();
    }
}
