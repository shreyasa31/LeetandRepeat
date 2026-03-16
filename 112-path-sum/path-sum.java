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
        return Sum(root,0,targetSum);
    }
    boolean Sum(TreeNode root, int sum,int targetSum){
       if(root==null) return false;
       sum=sum+root.val;
    if(root.left == null && root.right == null){
            return sum == targetSum;
        }

        return Sum(root.left, sum, targetSum) ||
               Sum(root.right, sum, targetSum);
    }
}