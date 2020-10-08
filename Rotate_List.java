/**
 * #61 : Medium
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
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
    public ListNode rotateRight(ListNode head, int k) {
        
        // get out quick
        if (head == null || k == 0)
            return head;
        
        // init
        ListNode temp = head;
        int len = 1;
        
        // determine length of list
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        
        // reset temp to head of list
        temp.next = head;
        k = k%len;
        
        // rearrange nodes
        for (int i = 0; i < len-k; i++)
            temp = temp.next;
        
        // cleanup
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}
