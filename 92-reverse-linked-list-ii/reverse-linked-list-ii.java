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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head;

        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int l=1;
        ListNode prev=dummy;
        while(curr!=null){
            if(l==left){
                break;
            }
            prev=curr;
            curr=curr.next;
            l++;
        }
    
 
      
        ListNode prev1=null;
       
        
        for(int i=0;i<=right-left;i++){
            
            ListNode temp=curr.next;
            curr.next=prev1;
            prev1=curr;
            curr=temp;
           
        }
        ListNode t=prev.next;
        prev.next=prev1;
        t.next=curr;
        return dummy.next;
    }
}