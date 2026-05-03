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
        int count=0;
        ListNode curr=head;
        ListNode first=null;
        while(curr!=null){
         count++;
            if(count==k)  first=curr;
            curr=curr.next;
           
       
        }
        // System.out.println(first.val);
        //   System.out.println(count);
        int len=count-k;
        ListNode curr1=head;
        for(int i=0;i<len;i++){
         curr1=curr1.next;

        }
        int temp=first.val;
        first.val=curr1.val;
        curr1.val=temp;

        return head;
        
            
    }
}