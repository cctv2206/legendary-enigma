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


// quick sort
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode cur = head.next;
        
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        
        ListNode largeHead = new ListNode(0);
        ListNode largeTail = largeHead;
        
        ListNode equal = head;
        
        while (cur != null) {
            if (cur.val < head.val) {
                smallTail.next = cur;
                smallTail = smallTail.next;
            } else if (cur.val > head.val){
                largeTail.next = cur;
                largeTail = largeTail.next;
            } else {
                equal.next = cur;
                equal = equal.next;
            }
            cur = cur.next;
        }
        
        smallTail.next = null;
        largeTail.next = null;
        equal.next = null;
        
        largeHead = largeHead.next;
        smallHead = smallHead.next;
        
        return join(join(sortList(smallHead), head), sortList(largeHead));
    }
    
    
    // join two list, return head
    public ListNode join(ListNode small, ListNode large) {
        if (small == null) {
            return large;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = small;
        
        while (small != null && small.next != null) {
            small = small.next;
        }
        small.next = large;
        return dummy.next;
    }
    
}
