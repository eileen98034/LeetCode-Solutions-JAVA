/*
#1290 : Easy
Given head which is a reference node to a singly-linked list. The value of each node in the 
linked list is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
*/
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
    public int getDecimalValue(ListNode head) {
        
        String binStr = Integer.toString(head.val);
        
        while (head.next != null) {
            binStr += Integer.toString(head.next.val);
            head.next = head.next.next;
        }
        
        return Integer.parseInt(binStr, 2);
        
    }
}
