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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode dummy=new ListNode(0);
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode c=dummy;
        while(curr!=null){
            ListNode nextPair=curr.next;
            c.next=curr;
            c=c.next;
            c.next=prev;
            c=c.next;
            prev=nextPair;
            curr=nextPair==null?null:nextPair.next;
        }
        c.next=prev;
        return dummy.next;
    }
}