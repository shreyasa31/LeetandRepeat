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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            count++;
           if(count==left){
                 break;
            }
            prev=curr;
            curr=curr.next;
             

        }
        ListNode prev2=null;

        for(int i=0;i<=right-left;i++){
            ListNode temp=curr.next;
            curr.next=prev2;
            prev2=curr;
            curr=temp;
        }
        ListNode t=prev.next;
        prev.next=prev2;
        t.next=curr;
        return dummy.next;
    }
}