// 3. Cycle Detection in a Linked List
// Problem Statement
// Detect if a linked list contains a cycle.

// Brute Force Approach (O(n)) using HashSet
// Use a HashSet to track visited nodes.
// If a node is visited again, return true.
// If we reach the end, return false.
// Optimized Approach (O(n)) using Floyd’s Cycle Detection Algorithm
// Use two pointers (slow and fast).
// Slow moves one step; fast moves two steps.
// If they meet, a cycle exists.
// If fast reaches null, no cycle exists.
package Hackerrank_Questions;

import java.io.*;
import java.util.*;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class CycleDetection {

    public static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null)
            return false;

        SinglyLinkedListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int index = scanner.nextInt();
            int n = scanner.nextInt();

            SinglyLinkedListNode head = null, tail = null, cycleNode = null;

            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

                if (head == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                }
                tail = newNode;

                if (i == index) {
                    cycleNode = newNode;
                }
            }

            if (tail != null && cycleNode != null) {
                tail.next = cycleNode;
            }

            System.out.println(hasCycle(head) ? 1 : 0);
        }

        scanner.close();
    }
}
