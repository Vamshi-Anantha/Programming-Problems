public class SinglyLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
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
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        void addAtFront(int val) {
            Node node = new Node(val);
            if (size == 0) {
                addAtLast(val);
            } else {
                node.next = head;
                head = node;
                size++;
            }
        }

        void printLinkedList() {
            if (size == 0) {
                System.out.println("Nothing in the linked list");
            } else {
                Node temp = head;
                while (temp != null) {
                    System.out.print(temp.data + "->");
                    temp = temp.next;
                }
                System.out.println("NULL");
            }
        }

        void addAtIndex(int val, int index) {
            if (index == 0) {
                addAtFront(val);
            } else if (index == size) {
                addAtLast(val);
            } else if (index > size) {
                System.out.println("Out of size");
            } else {
                Node prev = null;
                Node curr = head;
                int currentIndex = 0;
                while (currentIndex != index) {
                    prev = curr;
                    curr = curr.next;
                    currentIndex++;
                }
                Node node = new Node(val);
                node.next = curr;
                prev.next = node;
                size++;
            }
        }

        void deleteFront() {
            if (size == 0) {
                System.out.println("Nothing to delete");
            } else if (size == 1) {
                head = null;
                tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        void deleteLast() {
            if (size == 0) {
                System.out.println("Nothing to delete");
            } else if (size == 1) {
                head = null;
                tail = null;
                size = 0;
            } else {
                Node temp = head;
                int currentIndex = 0;
                while (currentIndex != size - 2) {
                    temp = temp.next;
                    currentIndex++;
                }
                temp.next = null;
                tail = temp;
                size--;
            }
        }

        void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                System.out.println("Nothing to delete");
            } else if (index == 0) {
                deleteFront();
            } else if (index == size - 1) {
                deleteLast();
            } else {
                int currentIndex = 0;
                Node temp = head;
                while (currentIndex != index - 1) {
                    temp = temp.next;
                    currentIndex++;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addAtLast(3);
        ll.addAtLast(5);
        ll.addAtLast(6);
        ll.addAtLast(7);

        ll.printLinkedList();
        ll.deleteAtIndex(2);
        ll.printLinkedList();
        ll.deleteAtIndex(2);
        ll.printLinkedList();
        ll.deleteAtIndex(1);
        ll.printLinkedList();
    }
}
