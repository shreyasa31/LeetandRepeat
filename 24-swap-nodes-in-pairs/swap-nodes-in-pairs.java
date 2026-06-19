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
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=head;
        ListNode second=head.next;
        ListNode prev=dummy;



        while(first !=null && second !=null){
            ListNode temp=second.next;
              prev.next=first.next;
            first.next=temp;
            second.next=first;

            prev=first;
            first=first.next;
           second=first!=null?first.next:null;
            
          


        }
        return dummy.next;


    }
}