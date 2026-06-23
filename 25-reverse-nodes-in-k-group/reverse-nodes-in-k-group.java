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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode c=head;
        int count=0;
        while(c!=null){
            c=c.next;
            count++;
        }

     
        ListNode prev=dummy;
        

        while(count>=k){
           ListNode first=prev.next;
           ListNode second=first.next;
           for(int i=1;i<k;i++){
         
             first.next = second.next;

        second.next = prev.next;
        prev.next = second;

        second = first.next;
              
           }
           prev=first;
           count=count-k;
          
        }

        return dummy.next;
    }
}