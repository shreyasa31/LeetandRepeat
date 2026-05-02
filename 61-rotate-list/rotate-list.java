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
    public ListNode rotateRight(ListNode head, int k) {
        int count=0;
        ListNode curr=head;
        if(head==null) return null;
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        count=count+1;
        curr.next=head;
        int k1=k%count;
        curr=head;
    
        for(int i=1;i<count-k1;i++){
            curr=curr.next;
        }
        ListNode newHead=curr.next;
        curr.next=null;
        return newHead;

    }
}