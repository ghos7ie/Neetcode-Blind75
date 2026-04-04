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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse 2nd half
        ListNode rev = slow.next;
        ListNode prev = slow.next = null; // slow.next should be null since it is at the end now
        while (rev != null) {
            ListNode temp = rev.next; // original slow.next.next
            rev.next = prev; 
            prev = rev;
            rev = temp;
        }

        // merge 
        ListNode first = head;
        rev = prev;
        while (rev != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = rev.next;
            first.next = rev;
            rev.next = temp1;
            first = temp1;
            rev = temp2;
        }
    }
}
