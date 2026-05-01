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
        ListNode beforeX=new ListNode(0);
        ListNode curr1=beforeX;

        ListNode afterX=new ListNode(0);
        ListNode curr2=afterX;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                curr1.next=curr;
                curr1=curr1.next;
            }else{
                curr2.next=curr;
                curr2=curr2.next;
            }
            curr=curr.next;
        }
        curr2.next=null;
        curr1.next=afterX.next;
        return beforeX.next;
    }
}