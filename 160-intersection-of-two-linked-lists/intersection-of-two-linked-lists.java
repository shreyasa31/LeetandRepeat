/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1=headA;
        ListNode curr2=headB;

        while(curr1!=null || curr2!=null){
              if(curr1==null){
                curr1=headB;
              
              }
              if(curr2==null){
                curr2=headA;
              }
              if(curr1==curr2) return curr1;
              curr1=curr1.next;
              curr2=curr2.next;

        }
        return null;
    }
}