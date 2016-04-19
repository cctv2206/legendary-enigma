/**

Sort a linked list using insertion sort.

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            if (head.next.val < head.val) {
                ListNode node = head.next;
                head.next = head.next.next;
                insert(dummy, node);
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    public void insert(ListNode dummy, ListNode node) {
        while (dummy.next != null && dummy.next.val < node.val) {
            dummy = dummy.next;
        }
        
        // dummy < node <= dummy.next
        node.next = dummy.next;
        dummy.next = node;
    }
}
