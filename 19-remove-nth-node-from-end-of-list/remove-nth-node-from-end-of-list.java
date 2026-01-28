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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        int count=0;
        while(curr!=null){
           
            curr=curr.next;
             count++;
        
        }
        curr=dummy;

         for(int i=0;i<count-n;i++){
  
           curr=curr.next;
        

        }
     
        curr.next=curr.next.next;
        return dummy.next;
        
    }
}