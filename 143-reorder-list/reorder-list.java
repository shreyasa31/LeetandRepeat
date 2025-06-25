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
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
            //  if(slow==fast) break;
        }

       
       ListNode otherHalf=slow.next;
       slow.next=null;
        ListNode prev=null;
        ListNode curr=otherHalf;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

            
        }
        

        ListNode list2=prev;
        ListNode list1=head;

        while(list1!=null && list2!=null){
           ListNode temp1=list1.next;
           ListNode temp2=list2.next;
            list1.next=list2;
         list1=temp1;
            list2.next=temp1;
          
             list2=temp2;
        }



}}