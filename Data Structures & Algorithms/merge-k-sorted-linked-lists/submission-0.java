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
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode x: lists){
            ListNode temp = x;
            while(temp!=null){
                pq.add(temp);
                temp=temp.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
        }

        return dummy.next;
    }
}
