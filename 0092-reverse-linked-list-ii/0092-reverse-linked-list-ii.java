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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1st method
        if(head == null || head.next == null) return head;
        if(left == right) return head;
        ListNode headPrev = null;
        ListNode head1 = null;
        ListNode tail1 = null;
        ListNode tailNext = null;
        ListNode temp = head;
        int index = 1;
        while(temp != null){
            if(index + 1 == left){
                headPrev = temp;
            }else if(index == left){
                head1 = temp;
            }else if(index == right){
                tail1 = temp;
            }else if(index == right + 1){
                tailNext = temp;
                break;
            }
            temp = temp.next;
            index++;
        }
        tail1.next = null;
        if(headPrev == null){
            head = reverse(head);
        }else{
            headPrev.next = null;
            headPrev.next = reverse(head1);
        }
        head1.next = tailNext;
        return head;
        // 2nd method
        // if (head == null || left == right) {
        //     return head;
        // }

        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode prev = dummy;

        // // Move `prev` to the node before `left`
        // for (int i = 1; i < left; i++) {
        //     prev = prev.next;
        // }

        // ListNode start = prev.next; // First node in the sublist
        // ListNode then = start.next; // The node after `start`

        // // Reverse the sublist from `left` to `right`
        // for (int i = 0; i < right - left; i++) {
        //     start.next = then.next;
        //     then.next = prev.next;
        //     prev.next = then;
        //     then = start.next;
        // }

        // return dummy.next;
    }
}
