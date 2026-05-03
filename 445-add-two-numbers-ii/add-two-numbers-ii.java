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
               //reverse it then add 
        // ListNode dummy=new ListNode(0);
        // dummy.next=l1;
        ListNode prev2=null;
        ListNode curr2=l1;

        while(curr2!=null){
            ListNode temp2=curr2.next;
            curr2.next=prev2;
            prev2=curr2;
            curr2=temp2;

        }

        ListNode prev1=null;
        ListNode curr1=l2;

        while(curr1!=null){
            ListNode temp1=curr1.next;
            curr1.next=prev1;
            prev1=curr1;
            curr1=temp1;

        }
        ListNode c1=prev1;
        ListNode c2=prev2;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        while(c1!=null || c2!=null){
            int n1=c1==null?0:c1.val;
            int n2=c2==null?0:c2.val;
            int sum=n1+n2+carry;
            carry=sum/10;
            ListNode res=new ListNode(sum%10);
            curr.next=res;
            curr=res;
            if(c1!=null) c1=c1.next;
            if(c2!=null)c2=c2.next;
        }
        if(carry>0){
            ListNode k=new ListNode(carry);
            curr.next=k;
        }
        ListNode prev3=null;
        ListNode r1=dummy.next;
        while(r1!=null){
            ListNode temp3=r1.next;
            r1.next=prev3;
            prev3=r1;
            r1=temp3;
        }
        return prev3;

    }
}