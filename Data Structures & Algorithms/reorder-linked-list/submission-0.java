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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        // reversing the second list
        ListNode temp = second;
        ListNode prev = null;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        // merge first and second
        ListNode frst = head;
        ListNode sec = prev;
    
        while(frst!=null && sec!=null){
            ListNode n1 = frst.next;
            ListNode n2 = sec.next;

            frst.next = sec;
            sec.next = n1;

            frst = n1;
            sec = n2;

        }
        
    }
}
