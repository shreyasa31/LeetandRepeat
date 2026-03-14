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
    public int maxLevelSum(TreeNode root) {
      int maxsum=Integer.MIN_VALUE; int l=1;int maxl=Integer.MIN_VALUE;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level=queue.size();
            int sum=0;
            for(int i=0;i<level;i++){
                TreeNode curr=queue.poll();
                sum+=curr.val;
                if(curr.left!=null) queue.add(curr.left);
                 if(curr.right!=null) queue.add(curr.right);
            }
            if(sum>maxsum){
                maxsum=sum;
                maxl=l;
            }
            l++;

        }
        return maxl;
    }
}