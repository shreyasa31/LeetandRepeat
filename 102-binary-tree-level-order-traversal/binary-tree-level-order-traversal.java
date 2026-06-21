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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<List<Integer>> res=new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level=queue.size();
            res.add(new ArrayList<>());

            for(int i=0;i<level;i++){
            
             
             TreeNode node=queue.poll();
             res.get(res.size()-1).add(node.val);
             
             if(node.left!=null){
               queue.add(node.left);
             }
             if(node.right!=null){
                queue.add(node.right);
             }

    
            }
        }
        return res;
    }
}