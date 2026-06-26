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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode mid=findMid(head);
        
        TreeNode newNode=new TreeNode(mid.val);
          if(head==mid) return newNode;
        newNode.left=sortedListToBST(head);
        newNode.right=sortedListToBST(mid.next);
        return newNode ;
    }
    ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(fast!=null && fast.next!=null){
            
            slow=slow.next;
            fast=fast.next.next;
            prev=prev.next;
        }
        prev.next=null;
        return slow;
    }

}