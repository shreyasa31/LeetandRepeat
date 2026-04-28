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
        int count=0;
       if(head.next==null) return null;
       
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
     if(count-n==0) return head.next;
        curr=head;
        ListNode prev=null;
        while(curr!=null){
              count--;
            ListNode temp=curr;
            curr=curr.next;
            prev=temp;
            if(count==n){
                ListNode t=curr.next;
                prev.next=t;
                return head;
                
            }
          

        }
       return null;
    }
}