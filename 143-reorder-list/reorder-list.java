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
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        ListNode head2=slow.next;
        slow.next=null;
        ListNode prev=null;
   
        while(head2!=null){
            ListNode temp=head2.next;
            head2.next=prev;
            prev=head2;
            head2=temp;
        }
        ListNode curr1=head;
        ListNode curr=prev;
        while(curr1!=null && curr!=null){
            ListNode temp1=curr1.next;
            ListNode temp2=curr.next;
            curr1.next=curr;
            curr.next=temp1;
            curr1=temp1;
            curr=temp2;

        }

      
    

    }
}