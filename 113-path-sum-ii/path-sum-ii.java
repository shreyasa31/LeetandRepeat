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
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> s= new ArrayList<>();
        return solve(root, 0, targetSum, s);
    }
    List<List<Integer>> solve(TreeNode root, int sum, int targetSum, List<Integer> s){
       if(root==null) return res;
       
        s.add(root.val);
        sum=sum+root.val;
        if(root.left==null && root.right==null && sum==targetSum){
             res.add(new ArrayList<>(s));
             
        }
        solve(root.left, sum, targetSum, s);
        solve(root.right, sum, targetSum, s);
        s.remove(s.size()-1);
        return res;

    }
}