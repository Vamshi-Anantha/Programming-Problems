// Question 1: Find Merge Point of Two Lists
// Problem Statement
// Given pointers to the head nodes of two singly linked lists that merge together at some point, find the node where the two lists merge. The merge point is where both lists reference the same memory location. Return the value of that node.

// Example
// less
// Copy
// Edit
// List #1: a → b → c
//                    \
//                     x → y → z → NULL
//                    /
// List #2: p → q
// Function Signature
// java
// Copy
// Edit
// static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
// Constraints
// The lists will always merge at some point.

// Sample Input
// yaml
// Copy
// Edit
// List 1: 1 → 2 → 3
//                \
//                 4 → 5 → 6
//                /
// List 2: 7 → 8
// Sample Output
// Copy
// Edit
// 4
// Java Solution

import java.util.*;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    SinglyLinkedListNode head;
    SinglyLinkedListNode tail;

    public void insertNode(int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }
}

public class FindMergePoint {
    public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        if (len1 > len2) {
            head1 = advancePointer(head1, len1 - len2);
        } else {
            head2 = advancePointer(head2, len2 - len1);
        }

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1.data;
    }

    private static int getLength(SinglyLinkedListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private static SinglyLinkedListNode advancePointer(SinglyLinkedListNode head, int steps) {
        while (steps-- > 0) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first linked list
        SinglyLinkedList list1 = new SinglyLinkedList();
        System.out.print("Enter number of nodes in List 1: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter elements of List 1:");
        for (int i = 0; i < n1; i++) {
            list1.insertNode(scanner.nextInt());
        }

        // Input for second linked list
        SinglyLinkedList list2 = new SinglyLinkedList();
        System.out.print("Enter number of nodes in List 2: ");
        int n2 = scanner.nextInt();
        System.out.println("Enter elements of List 2:");
        for (int i = 0; i < n2; i++) {
            list2.insertNode(scanner.nextInt());
        }

        // Merging lists at a specific node
        System.out.print("Enter merge index (0-based) in List 1: ");
        int mergeIndex = scanner.nextInt();
        SinglyLinkedListNode mergeNode = list1.head;
        for (int i = 0; i < mergeIndex; i++) {
            mergeNode = mergeNode.next;
        }

        SinglyLinkedListNode lastNodeList2 = list2.head;
        while (lastNodeList2.next != null) {
            lastNodeList2 = lastNodeList2.next;
        }
        lastNodeList2.next = mergeNode; // Merge the second list at the given index

        // Find merge point
        int result = findMergeNode(list1.head, list2.head);
        System.out.println("Merge point data: " + result);

        scanner.close();
    }
}
