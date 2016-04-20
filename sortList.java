/**

Sort a linked list in O(n log n) time using constant space complexity.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// cannot use insertion sort
// use merge sort
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // break list
        ListNode head2 = middle(head);
        
        return merge(sortList(head), sortList(head2));
    }
    
    
    // merge two list, return head
    public ListNode merge(ListNode node1, ListNode node2) {
     
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }

        cur.next = (node1 == null) ? node2 : node1;

        return dummy.next;
    }
    
    // break the list, return the middle
    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode tail = new ListNode(0);
        tail.next = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            tail = tail.next;
        }
        
        tail.next = null;
        return slow;
    }
}
