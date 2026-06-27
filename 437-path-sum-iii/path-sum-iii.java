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
    HashMap<Long, Integer> map=new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
         
         map.put(0L,1);
        return solve(root, targetSum,0);
    }
   
    int count=0;
    int solve(TreeNode root, int targetSum, long sum){
    if(root==null) return 0;
   
    sum=sum+root.val;
   

    if(map.containsKey(sum-targetSum))
    {
        count+=map.getOrDefault(sum-targetSum,0);
    }

    map.put(sum, map.getOrDefault(sum, 0)+1 );


    solve(root.left, targetSum, sum);
    solve(root.right, targetSum, sum);
    map.put(sum, map.get(sum) - 1);

    
   return count;

    }
}