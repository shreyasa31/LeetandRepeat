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
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> arr=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root==null) return res;
        arr.add(root.val);
        int sum=targetSum-root.val;
       
        if(root.left==null && root.right==null && sum==0){
             res.add(new ArrayList<>(arr));
           

          
        }
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        arr.remove(arr.size() - 1);

        return res;
    }
}