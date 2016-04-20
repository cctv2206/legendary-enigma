/**

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        
        addHelper(l1, l2, 0);
        
        return dummy.next;
        
        
    }
    
    public void addHelper(ListNode l1, ListNode l2, int bit) {
        int sum = l1.val + l2.val + bit;
        bit = sum / 10;
        l1.val = sum % 10;
        
        if (l1.next != null && l2.next != null) {
            addHelper(l1.next, l2.next, bit);
        } else if (l1.next == null && l2.next != null) {
            if (bit == 1) {
                addOne(l2.next);
            }
            l1.next = l2.next;
        } else  { // l2 = null
            if (bit == 1) {
                l1.next = addOne(l1.next);
            }
        } 
    }
    
    public ListNode addOne(ListNode node) {
        if (node == null) {
            return new ListNode(1);
        }
        int sum = node.val + 1;
        int bit = sum / 10;
        node.val = sum % 10;
        if (bit == 1) {
            node.next = addOne(node.next);
        }
        return node;
    }
}
