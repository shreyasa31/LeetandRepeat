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
     Queue<TreeNode> queue=new LinkedList<>();
     queue.add(root);
     int l=1; int max=Integer.MIN_VALUE; int maxl=1;
     while(!queue.isEmpty()){

        int level=queue.size();
        int sum=0;
        for(int i=0;i<level;i++){
           TreeNode curr=queue.poll();
           sum=sum+curr.val;
           if(curr.left!=null) queue.add(curr.left);
           if(curr.right!=null) queue.add(curr.right);
        }
        if(sum>max){
            max=sum;
            maxl=l;
        }
        l++;


     }
     return maxl;
    }
}