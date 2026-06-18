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
        if(head==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(newHead!=null){
            ListNode temp=newHead.next;
            newHead.next=prev;
            prev=newHead;
            newHead=temp;
        }

        ListNode curr2=prev;


        ListNode curr1=head;
        ListNode dummy=new ListNode(0);
        ListNode present=dummy;
        while(curr1!=null && curr2!=null){
            ListNode temp1=curr1.next;
            present.next=curr1;
            present=present.next;
            curr1=temp1;

            ListNode temp2=curr2.next;
            present.next=curr2;
            present=present.next;
            curr2=temp2;


            
 
        }
        if(curr1!=null){
            present.next=curr1;
        }
        if(curr2!=null){
            present.next=curr2;
        }
        
        
    }
}