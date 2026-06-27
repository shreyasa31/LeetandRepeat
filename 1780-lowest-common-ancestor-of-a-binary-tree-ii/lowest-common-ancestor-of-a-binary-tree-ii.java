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
    boolean foundp=false; boolean foundq=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

       TreeNode l=lca(root, p, q);
       if(foundp && foundq){
        return l;
       }
       return null ;
    }
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
       
        TreeNode left=lca(root.left, p,q);
        TreeNode right=lca(root.right, p,q);
         if(root==p){
          foundp=true;
          return root;
        }
        if(root==q){
          foundq=true;
        return root;
        }
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }
        return root;
    }
}