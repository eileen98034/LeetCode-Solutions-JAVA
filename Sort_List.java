/*
#148 : Medium
Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
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
    public ListNode sortList(ListNode head) {
        
        ListNode node = head;
        while (node != null) {
            ListNode nextNode = node.next;
            while (nextNode != null) {
                if (node.val > nextNode.val) {
                    int temp = node.val;
                    node.val = nextNode.val;
                    nextNode.val = temp;
                }
                nextNode = nextNode.next;
            }
            node = node.next;
        } 
        return head;
    }
}
