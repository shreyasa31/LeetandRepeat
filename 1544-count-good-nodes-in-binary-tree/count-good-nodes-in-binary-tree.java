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
    int count=0;
       
    public int goodNodes(TreeNode root) {
       
       return Count(root, Integer.MIN_VALUE);
          
         

    }
    int Count(TreeNode node, int max){
           if(node==null) return count;
         if(max<=node.val){
            max=node.val;
            count++;
         }
         
        Count(node.left,max);
        Count(node.right, max);
         return count;
    }
}