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
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for(int i=0;i<res.size()-1;i++){
            if(res.get(i)>=res.get(i+1)){
                return false;
            }
        }
        return true;
    }
    ArrayList<Integer> res=new ArrayList<>();
    ArrayList<Integer> inOrder(TreeNode root){
        if(root==null) return null;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
        return res;
    }
   
}