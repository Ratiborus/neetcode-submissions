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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> h = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode n : lists) {
            ListNode tail = n;
            while(tail!= null) {
                h.add(tail);
                tail = tail.next;
            }
        }
        ListNode res = new ListNode();
        ListNode tail = res;
        while(!h.isEmpty()) {
            tail.next = h.poll();
            tail = tail.next;
        }
        return res.next;
    }
}
