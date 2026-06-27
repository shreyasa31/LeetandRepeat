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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      
        List<List<Integer>> res=new ArrayList<>();
          if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root); boolean turn=false;
        while(!queue.isEmpty()){
          int level=queue.size();
          List<Integer> partition=new ArrayList<>();

          for(int i=0;i<level;i++){
            TreeNode pop=queue.poll();
            partition.add(pop.val);
            if(pop.left!=null){
                queue.add(pop.left);
            }
             if(pop.right!=null){
                queue.add(pop.right);
            }
          }
          if(turn){
              Collections.reverse(partition);
          }
          res.add(partition);
          turn=!turn;

        }
        return res;
    }
}