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
    int count=0;
    public int goodNodes(TreeNode root) {
        int max=Integer.MIN_VALUE;
        
        return solve(root, max);
    }
    int solve(TreeNode root, int max){
        if(root==null) return 0;
        if(max<=root.val){
            max=root.val;
            count++;
        }
        solve(root.left,max );
        solve(root.right,max);
        return count;

    }
}