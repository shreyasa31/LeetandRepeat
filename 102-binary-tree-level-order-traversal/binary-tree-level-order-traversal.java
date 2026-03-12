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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> rs=new ArrayList<>();

        levels(root,0,rs);
        return rs;
    }

    List<List<Integer>>  levels(TreeNode root, int level, List<List<Integer>> res){
        if(root==null) return res;
        if(level==res.size()) res.add(new ArrayList<Integer>());
        
        res.get(level).add(root.val);
        levels(root.left, level+1,res);
        levels(root.right, level+1,res);
        return res;
     
    }
}