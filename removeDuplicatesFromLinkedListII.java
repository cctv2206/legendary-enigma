/** 

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        boolean duplicates = false;
        while (head != null) {
            while (head.next != null && head.next.val == pre.next.val) {
                head = head.next;
                duplicates = true;
            }
            if (pre.next != head) {
                head = head.next;
                pre.next = head;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pre.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }
        
        return dummy.next;
    }
}
