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
    PriorityQueue<Integer> maxHeap =new PriorityQueue<>((a,b)->b-a);
    public int kthSmallest(TreeNode root, int k) {
     
        if(root==null) return 0;

        maxHeap.add(root.val);
        if(maxHeap.size()>k){
            maxHeap.poll();
        }
        kthSmallest(root.left, k);
           kthSmallest(root.right, k);
        return maxHeap.peek();
    }
}