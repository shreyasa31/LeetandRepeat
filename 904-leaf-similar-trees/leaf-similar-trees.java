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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> s1=leafArray(root1); 
        ArrayList<Integer> s2=leafArray(root2); 
        return s1.equals(s2);
           }
    ArrayList<Integer> leafArray(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
              root=stack.pop();
              if(root.left ==null && root.right==null){
                res.add(root.val);
              }

              if(root.right!=null){
                stack.push(root.right);
              }
               if(root.left!=null){
                stack.push(root.left);
              }
        }
        return res;
    }
}