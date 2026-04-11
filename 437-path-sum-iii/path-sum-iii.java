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
          HashMap<Long,Integer> map=new HashMap<>();
         
       
          
    public int pathSum(TreeNode root, int targetSum) {
  
       map.put(0L,1);
       return dfs(root, 0L, targetSum);
       

    }

    int dfs(TreeNode root, long prefixSum, int targetSum){
             int count=0;
         if(root==null){
            return count;
        }
      
        prefixSum+=root.val;
       
        if(map.containsKey(prefixSum-targetSum)){
           count+=map.get(prefixSum-targetSum);
        }
        map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        count+=dfs(root.left, prefixSum, targetSum);
        count+=dfs(root.right, prefixSum, targetSum);
        map.put(prefixSum, map.get(prefixSum) - 1);
        return count;
    }
}