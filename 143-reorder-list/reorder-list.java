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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            break;
        }


        ListNode curr=slow;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        ListNode node=head;
        ListNode second=prev;
        while(node.next!=null && second.next!=null){
           ListNode temp1=node.next;
           ListNode temp2=second.next;


           node.next=second;
           node=temp1;

           second.next=temp1;
           second=temp2;
        }

    }
}