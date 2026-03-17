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
    int k=0;
    public int sumNumbers(TreeNode root) {
         return Sum(root,0);
    }
    int Sum(TreeNode root, int sum){
         
        if(root==null) return sum;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null){
            k+=sum;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
        return k;
    }
}