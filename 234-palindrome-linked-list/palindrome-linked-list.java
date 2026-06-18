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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;

        }

        ListNode newPair=slow.next;
        slow.next=null;

        ListNode prev=null;
        while(newPair!=null){
            ListNode temp=newPair.next;
            newPair.next=prev;
            prev=newPair;
            newPair=temp;

        }
        ListNode curr1=head;
        ListNode curr2=prev;
      

        while(curr1!=null && curr2!=null){
            if(curr1.val!=curr2.val){
                return false;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }


        return true;
    }
}