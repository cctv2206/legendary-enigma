/**

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            pre.next = head.next;
            head.next = head.next.next;
            pre = pre.next;
            pre.next = head;
            head = head.next;
            pre = pre.next;
        }
        
        return dummy.next;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = head.next;
        ListNode rest = head.next.next;
        
        newHead.next = head;
        head.next = swapPairs(rest);
        
        return newHead;
    }
}
