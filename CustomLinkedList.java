import java.util.*;

class CustomLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head, tail;
    int size;

    CustomLinkedList() {
        head = tail = null;
        size = 0;
    }

    void addAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            addAtFront(data);
            return;
        }
        if (index == size) {
            addAtTail(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
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
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    int getFront() {
        return head != null ? head.data : -1;
    }

    int getTail() {
        return tail != null ? tail.data : -1;
    }

    void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head == null)
                tail = null;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null)
                tail = temp;
        }
        size--;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addAtFront(10);
        list.addAtTail(20);
        list.addAtTail(30);
        list.addAtIndex(1, 15);
        list.printList();
        System.out.println("Index 2: " + list.getIndex(2));
        System.out.println("Front: " + list.getFront());
        System.out.println("Tail: " + list.getTail());
        list.removeAtIndex(1);
        list.printList();
    }
}
