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
        ListNode dummy=new ListNode(0);
        int sum=0;
        ListNode curr=dummy; int carry=0;
        while(l1!=null || l2!=null){
             int num1= l1==null? 0:l1.val;
             int num2=l2==null?0:l2.val;
             sum=num1+num2+carry;

             int rem=sum%10;
             carry=sum/10;


             ListNode newNode=new ListNode(rem);
             curr.next=newNode;
             curr=curr.next;
             
             if(l1!=null)
             l1=l1.next;
             if(l2!=null)
             l2=l2.next;
        }
        if(carry!=0){
            ListNode car=new ListNode(carry);
            curr.next=car;

        }
        return dummy.next;
    }
}