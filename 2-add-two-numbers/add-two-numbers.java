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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int quotient=0;
        while(p1!=null || p2!=null){
            int value1=p1==null?0:p1.val;
            int value2=p2==null?0:p2.val;
            int sum=quotient+value1+value2;
            int rem=sum%10;
            quotient=sum/10;
            ListNode newNode=new ListNode(rem);
            curr.next=newNode;
            curr=curr.next;
            if(p1!=null)
            p1=p1.next;
            if(p2!=null)
            p2=p2.next;
        }
        if(quotient>0){
            ListNode q=new ListNode(quotient);
            curr.next=q;
        }
        return dummy.next;
    }
}