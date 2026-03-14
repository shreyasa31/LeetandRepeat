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
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> res=new ArrayList<>();
                if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level=queue.size();
            for(int i=0;i<level;i++){
                TreeNode curr=queue.poll();
                if(i==level-1){
                    res.add(curr.val);
                }
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
        }
        return res;
    }
}