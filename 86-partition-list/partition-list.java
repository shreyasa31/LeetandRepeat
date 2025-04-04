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
    public ListNode partition(ListNode head, int x) {
        ListNode before=new ListNode(0);
        ListNode beforecurr=before;
        
        ListNode after=new ListNode(0);
        ListNode aftercurr=after;
        ListNode curr=head;
        while(curr!=null){
             if(curr.val<x){
                  beforecurr.next=curr;
                  beforecurr=beforecurr.next; 
                  
             }else{
                aftercurr.next=curr;
                aftercurr=aftercurr.next;
             }
             curr=curr.next;

        }
        aftercurr.next=null;

        beforecurr.next=after.next;
        return before.next;

    }
}