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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode curr:lists){
            if(curr!=null)
            minHeap.add(curr);
            
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!minHeap.isEmpty()){
         ListNode ans=minHeap.poll();
         curr.next=ans;
         curr=curr.next;
         if(ans.next!=null){
             minHeap.add(ans.next);
         }
        }
        return dummy.next;
    }
}