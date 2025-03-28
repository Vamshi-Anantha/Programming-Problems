import java.util.*;

public class SinglyLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        void addAtLast(int val) {
            Node node = new Node(val);
            if (size == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        void addAtFront(int val) {
            Node node = new Node(val);
            if (size == 0) {
                head = tail = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        void printLinkedList() {
            if (size == 0) {
                System.out.println("Nothing in the linked list");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }

        void addAtIndex(int val, int index) {
            if (index < 0 || index > size) {
                System.out.println("Invalid index");
                return;
            }
            if (index == 0) {
                addAtFront(val);
            } else if (index == size) {
                addAtLast(val);
            } else {
                Node prev = head;
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
                Node node = new Node(val);
                node.next = prev.next;
                prev.next = node;
                size++;
            }
        }

        void deleteFront() {
            if (size == 0) {
                System.out.println("Nothing to delete");
                return;
            }
            head = head.next;
            if (head == null)
                tail = null;
            size--;
        }

        void deleteLast() {
            if (size == 0) {
                System.out.println("Nothing to delete");
                return;
            }
            if (size == 1) {
                head = tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
        }

        void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                System.out.println("Invalid index");
                return;
            }
            if (index == 0) {
                deleteFront();
            } else if (index == size - 1) {
                deleteLast();
            } else {
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        int getIndex(int index) {
            if (index < 0 || index >= size) {
                System.out.println("Invalid index");
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        int getFront() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }

        int getTail() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addAtLast(3);
        ll.addAtLast(5);
        ll.addAtLast(6);
        ll.addAtLast(7);

        System.out.println("Original Linked List:");
        ll.printLinkedList();

        System.out.println("Element at index 2: " + ll.getIndex(2));
        System.out.println("Front element: " + ll.getFront());
        System.out.println("Tail element: " + ll.getTail());

        ll.deleteAtIndex(2);
        System.out.println("After deleting index 2:");
        ll.printLinkedList();

        ll.deleteAtIndex(2);
        System.out.println("After deleting index 2 again:");
        ll.printLinkedList();

        ll.deleteAtIndex(1);
        System.out.println("After deleting index 1:");
        ll.printLinkedList();
    }
}

// import java.util.*;

// class SingleLinkedList {
// static class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// this.next = null;
// }
// }

// Node head, tail;
// int size;

// SingleLinkedList() {
// head = tail = null;
// size = 0;
// }

// // Add element at the front
// void addAtFront(int data) {
// Node newNode = new Node(data);
// if (head == null) {
// head = tail = newNode;
// } else {
// newNode.next = head;
// head = newNode;
// }
// size++;
// }

// // Add element at the tail
// void addAtTail(int data) {
// Node newNode = new Node(data);
// if (tail == null) {
// head = tail = newNode;
// } else {
// tail.next = newNode;
// tail = newNode;
// }
// size++;
// }

// // Add element at a specific index
// void addAtIndex(int index, int data) {
// if (index < 0 || index > size) {
// System.out.println("Invalid index");
// return;
// }
// if (index == 0) {
// addAtFront(data);
// return;
// }
// if (index == size) {
// addAtTail(data);
// return;
// }
// Node newNode = new Node(data);
// Node temp = head;
// for (int i = 0; i < index - 1; i++) {
// temp = temp.next;
// }
// newNode.next = temp.next;
// temp.next = newNode;
// size++;
// }

// // Get element at a specific index
// int getIndex(int index) {
// if (index < 0 || index >= size) return -1;
// Node temp = head;
// for (int i = 0; i < index; i++) {
// temp = temp.next;
// }
// return temp.data;
// }

// // Get first element
// int getFront() {
// return head != null ? head.data : -1;
// }

// // Get last element
// int getTail() {
// return tail != null ? tail.data : -1;
// }

// // Remove element at a specific index
// void removeAtIndex(int index) {
// if (index < 0 || index >= size) {
// System.out.println("Invalid index");
// return;
// }
// if (index == 0) {
// head = head.next;
// if (head == null) tail = null;
// } else {
// Node temp = head;
// for (int i = 0; i < index - 1; i++) {
// temp = temp.next;
// }
// temp.next = temp.next.next;
// if (temp.next == null) tail = temp;
// }
// size--;
// }

// // Print all elements in the linked list
// void printList() {
// Node temp = head;
// while (temp != null) {
// System.out.print(temp.data + " -> ");
// temp = temp.next;
// }
// System.out.println("null");
// }

// public static void main(String[] args) {
// SingleLinkedList list = new SingleLinkedList();

// // Adding elements
// list.addAtFront(10);
// list.addAtTail(20);
// list.addAtTail(30);
// list.addAtIndex(1, 15);

// // Printing list
// System.out.println("Linked List:");
// list.printList();

// // Accessing elements
// System.out.println("Element at index 2: " + list.getIndex(2));
// System.out.println("Front: " + list.getFront());
// System.out.println("Tail: " + list.getTail());

// // Removing an element
// list.removeAtIndex(1);

// // Printing updated list
// System.out.println("After removing element at index 1:");
// list.printList();
// }
// }
