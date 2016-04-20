/**

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        
        ListNode newHead = head;
        ListNode ahead = head;
        ListNode pre = new ListNode(0);
        pre.next = newHead;
        int count = 1;
        
        // count list
        while (ahead.next != null) {
            ahead = ahead.next;
            count++;
        }
        
        k = k % count;
        
        if (k == 0) {
            return head;
        }

        ahead = head;
        while (k > 1) {
            ahead = ahead.next;
            k--;
        }

        while (ahead.next != null) {
            ahead = ahead.next;
            newHead = newHead.next;
            pre = pre.next;
        }
        
        ahead.next = head;
        pre.next = null;
        
        return newHead;
    }
}
