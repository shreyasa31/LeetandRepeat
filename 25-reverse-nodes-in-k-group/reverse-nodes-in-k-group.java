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

     
        ListNode beforeHead=dummy;
        

        while(count>=k){
        ListNode groupStart = beforeHead.next;
        ListNode prev=null;
        ListNode curr= groupStart;
            for(int i=0;i<k;i++){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            beforeHead.next=prev;
            groupStart.next=curr;

            beforeHead=groupStart;
            count=count-k;
        }

        return dummy.next;
    }
}