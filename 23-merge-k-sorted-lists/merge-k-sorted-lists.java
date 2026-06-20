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
        for(ListNode node:lists){
            if(node!=null)
            minHeap.add(node);
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();
            curr.next=node;
            curr=curr.next;
            if(node.next!=null){
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }
}