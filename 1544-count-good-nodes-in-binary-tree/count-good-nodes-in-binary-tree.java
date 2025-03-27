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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
           int maxnumber=Integer.MIN_VALUE; int count=0;
         Stack<Pair<TreeNode, Integer>> stack=new Stack<>();
         stack.push(new Pair(root, root.val));

         while(!stack.isEmpty()){
            Pair<TreeNode, Integer> res=stack.pop();
            root=res.getKey();
            int max=res.getValue();
            if(root.val>=max){
                count++;
            }


            maxnumber=Math.max(max,root.val);

            if(root.left!=null){
                stack.push(new Pair(root.left,maxnumber));
            }
            
            if(root.right!=null){
                stack.push(new Pair(root.right,maxnumber));
            }
            
         }

         return count;

    
    }
}