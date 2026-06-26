/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean flag=false;boolean flag1=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
        TreeNode lca = lca(root, p, q);

        if (flag && flag1) {
            return lca;
        }

        return null;
      
    }
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
          if(root==null) return null;
     
        TreeNode left=lca(root.left, p, q);
        TreeNode right=lca(root.right, p, q);
           if(root==p){
            flag=true;
            return root;
        }
        if(root==q){
             flag1=true;
            return root;
        }
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
}