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
// class Solution {
//     public ListNode reverseEvenLengthGroups(ListNode head) {
        
//     }
// }


class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;
        ListNode current = head;
        int groupSize = 1;

        while (current != null) {
            // Find actual size of current group
            ListNode temp = current;
            int count = 0;
            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }

            // Check if we should reverse
            if (count % 2 == 0) {
                // Reverse the group of size count
                ListNode prev = temp;
                ListNode node = current;
                for (int i = 0; i < count; i++) {
                    ListNode next = node.next;
                    node.next = prev;
                    prev = node;
                    node = next;
                }
                // Connect with previous group
                prevGroupEnd.next = prev;
                prevGroupEnd = current;
                current = temp;
            } else {
                // No reversal; just move pointers
                for (int i = 0; i < count; i++) {
                    prevGroupEnd = current;
                    current = current.next;
                }
            }
            groupSize++;
        }

        return dummy.next;
    }
}
