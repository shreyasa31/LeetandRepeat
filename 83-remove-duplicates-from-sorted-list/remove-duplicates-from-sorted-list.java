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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        if(head==null) return null;
        ListNode prev=head;ListNode curr=prev.next;

        while(curr!=null){
            if(curr.val==prev.val){
                prev.next=curr.next;
                

            }else{
                prev=curr;
            }
            curr=curr.next;

         
        }
        return dummy.next;
    }
}