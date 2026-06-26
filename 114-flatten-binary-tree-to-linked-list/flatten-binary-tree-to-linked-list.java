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
    public void flatten(TreeNode root) {
         preOrder(root);
    }
    TreeNode prev=null;
    void preOrder(TreeNode root){

        if(root==null) return;
        preOrder(root.right);
        preOrder(root.left);

     
        root.right=prev;
           root.left=null;

        prev=root;




    }
}