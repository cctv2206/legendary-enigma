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
            return head;
        }
        
        ListNode ahead = head;
        int count = 1;
        
        // count list
        while (ahead.next != null) {
            ahead = ahead.next;
            count++;
        }
        
        k %= count;
        
        if (k == 0) {
            return head;
        }
        
        // make a circle
        ahead.next = head;
        for (int i = 0; i < count - k; i++) {
            ahead = ahead.next;
        }
        head = ahead.next;
        ahead.next = null;
        return head;
    }
}
