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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
      return  path(root,0,targetSum);

    }
    boolean path(TreeNode n, int sum, int targetSum){
        if(n==null) return false;
        sum=sum+n.val;
      if(n.left == null && n.right == null){
            return sum == targetSum;
        }
        return path(n.left, sum, targetSum) || path(n.right, sum, targetSum);
    }
}