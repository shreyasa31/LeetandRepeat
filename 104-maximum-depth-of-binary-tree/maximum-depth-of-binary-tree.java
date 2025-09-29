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
    public int maxDepth(TreeNode root) {
       Stack<TreeNode> stack=new Stack<>();
       Stack<Integer> depth=new Stack<>();
       if(root==null) return 0;
       stack.push(root);
       depth.push(1);
       int max=0; int currdepth=0;
       while(!stack.isEmpty()){
          root=stack.pop();
          currdepth=depth.pop();
          max=Math.max(max,currdepth);
      if(root.left!=null){
            stack.push(root.left);
            depth.push(currdepth+1);
          }
          if(root.right!=null){
            stack.push(root.right);
            depth.push(currdepth+1);
          }
         
        
          
       }
       return max;

    }
}