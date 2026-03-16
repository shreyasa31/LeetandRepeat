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
    public boolean isBalanced(TreeNode root) {
      
      if(root==null) return true;

      return Math.abs(maxDepth(root.left)-maxDepth(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);


    }
    int maxDepth(TreeNode root){
        if(root==null) return 0;
        int max=Math.max(maxDepth(root.left),maxDepth(root.right));
        return max+1;
    }
}