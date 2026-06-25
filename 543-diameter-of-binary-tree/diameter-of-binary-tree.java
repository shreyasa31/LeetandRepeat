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
    int diameter=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        diameter=Math.max(diameter, left+right);
        return Math.max(left, right)+1;
    }
}