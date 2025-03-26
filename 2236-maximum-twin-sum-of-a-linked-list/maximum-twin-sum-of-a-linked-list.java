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
    public int pairSum(ListNode head) {
         ListNode fast=head;
         ListNode slow=head;

        //find the middle element;
         while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
         }
         //reverse
       
         ListNode prev=null;
         ListNode curr=slow;
         while(curr!=null){

            ListNode s=curr.next;
            curr.next=prev;
            prev=curr;
            curr=s;
         }
        //  return prev.val;
        //calculate max
         int max=0;
         ListNode start=head;
         while(prev!=null){
            max=Math.max(max, start.val+prev.val);
            prev=prev.next;
            start=start.next;
         }
         return max;

        
    }
}