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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while(list1 != null && list2 != null) {
                ListNode tmp = tail;
            if (list1.val <list2.val) {
                tail = list1;
                list1 = list1.next;
            } else {
                tail = list2;
                list2 = list2.next;
            }
                tmp.next = tail;
                tail.next = null;
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return head.next;
    }
}