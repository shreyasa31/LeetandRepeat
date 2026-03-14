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
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        int level=0;
        queue.add(root);
        boolean lefttoright=false;
        while(!queue.isEmpty()){
           res.add(new ArrayList<>());
           level=queue.size();
           for(int i=0;i<level;i++){
            TreeNode curr=queue.poll();
            if(lefttoright){
                   res.get(res.size()-1).addFirst(curr.val);
            }else{
                 res.get(res.size()-1).addLast(curr.val);
            }
           
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null)  queue.add(curr.right);

           }
           lefttoright=!lefttoright;
           
        }
        return res;
    }
}