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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
         ListNode curr1=head;
        ListNode prev=null;
        int k1=1;int count=0;
        while(curr1!=null){
            curr1=curr1.next;
            count++;
        }
        while(curr!=null){
            if(k1==k) break;
            curr=curr.next;
            k1++;
        }
        ListNode f1=curr;
        System.out.println(curr.val);
        ListNode curr2=head;
        for(int i=0;i<=count-k-1;i++){
            curr2=curr2.next;


        }
          
        ListNode f2=curr2;
 System.out.println(f2.val);
        int temp=f1.val;
        f1.val=f2.val;
        f2.val=temp;
        return head;


    }
}