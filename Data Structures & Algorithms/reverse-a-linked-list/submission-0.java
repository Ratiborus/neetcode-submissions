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
// 0, 1, 2, 3
// tmp = 0
// next = 1
// next.next = 2
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode next = head.next;
        head.next = null;
        while(next != null) {
            ListNode second = next.next;
            next.next = prev;
            prev = next;
            next = second; 
        }
        return prev;
    }
}
