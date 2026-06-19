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
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode evenHead=curr;
        while(curr!=null && curr.next!=null){
            ListNode temp=curr.next;
          prev.next=temp;
          curr.next=temp.next;
          prev=prev.next;
          curr=curr.next;
        }
        prev.next=evenHead;
        return head;
    }
}