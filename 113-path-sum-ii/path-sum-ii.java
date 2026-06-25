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
     ArrayList<Integer> s=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> s=new ArrayList<>();
        return solve(root, res, s, 0, targetSum);
    }
    List<List<Integer>> solve(TreeNode root, List<List<Integer>> res,List<Integer> s,int sum, int targetSum){
       
        if(root==null ) return res;
        s.add(root.val);
        sum=sum+root.val;
        if(root.left==null && root.right==null && sum==targetSum ){
            res.add(new ArrayList<>(s));

        }
       
        solve(root.left, res,s,sum, targetSum);
        solve(root.right, res,s, sum, targetSum);
        s.remove(s.size()-1);
        return res;

    }
}