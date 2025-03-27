import java.util.*;

class CustomQueue {
    static class Queue {
        ArrayList<Integer> list;

        Queue() {
            list = new ArrayList<>();
        }

        // Enqueue (Add element at the rear)
        void enqueue(int element) {
            list.add(element);
        }

        // Peek (Get front element)
        int peek() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(0);
        }

        // Dequeue (Remove element from front)
        int dequeue() {
            if (list.isEmpty()) {
                return -1;
            }
            int element = list.get(0);
            list.remove(0);
            return element;
        }

        // Get size of queue
        int getSize() {
            return list.size();
        }

        // Check if queue is empty
        boolean isEmpty() {
            return list.isEmpty();
        }

        // Print queue elements
        void printQueue() {
            if (list.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Queue elements (front to rear):");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Print queue before dequeuing
        q.printQueue();

        System.out.println("\nPeek: " + q.peek());

        System.out.println("\nDequeuing elements:");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        // Print queue after dequeuing
        System.out.println("\nQueue after dequeuing:");
        q.printQueue();
    }
}
