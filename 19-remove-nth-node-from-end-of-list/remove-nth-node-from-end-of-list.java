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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }

        int nodesbeforeRemove=count-n;
        ListNode prev=null;
        ListNode curr1=head;
     if(nodesbeforeRemove==0) return head.next;
       while(curr1!=null){
        if(nodesbeforeRemove==0){
            ListNode temp=curr1.next;
            prev.next=temp;
            return head;
            
        }
        prev=curr1;
        curr1=curr1.next;
        nodesbeforeRemove--;

       }
           

        return null;
    }
}