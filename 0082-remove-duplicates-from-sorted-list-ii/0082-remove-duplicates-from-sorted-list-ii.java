/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 1st method
        if (head == null || head.next == null) {
            return head;
        }

        // Find the first distinct node to be the new head
        while (head != null && head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next; // Skip duplicates
            }
            head = head.next; // Move to the next new value
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next; // Skip duplicates
                }
                if (prev == null) {
                    head = current.next; // Update head if first node was duplicate
                } else {
                    prev.next = current.next; // Remove duplicate nodes
                }
            } else {
                prev = current; // Move prev pointer forward
            }
            current = current.next; // Move forward
        }

        return head;
        // 2nd method
        // if (head == null || head.next == null) {
        //     return head;
        // }

        // ListNode dummy = new ListNode(0); // Dummy node before head
        // dummy.next = head;
        // ListNode prev = dummy;

        // while (head != null) {
        //     // If there's a duplicate
        //     if (head.next != null && head.val == head.next.val) {
        //         // Skip all nodes with the same value
        //         while (head.next != null && head.val == head.next.val) {
        //             head = head.next;
        //         }
        //         prev.next = head.next; // Remove duplicates
        //     } else {
        //         prev = prev.next; // Move prev pointer if no duplicate
        //     }
        //     head = head.next; // Move forward
        // }

        // return dummy.next;
    }
}
