/*
#147 : Medium

Sort a linked list using insertion sort.
The solution below is NOT an insertion sort.

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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode temp = head;
        
        List<Integer> valLst = new ArrayList<>();
        while (temp != null) {
            valLst.add(temp.val);
            temp = temp.next;
        }
        
        Collections.sort(valLst);
        
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.val = valLst.get(i++);
            temp = temp.next;
        }

        return head;
    }
}
