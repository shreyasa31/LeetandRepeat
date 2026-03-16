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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
       Queue<Pair<TreeNode,Integer>> queue=new LinkedList<>();
       queue.add(new Pair<>(root,0));
       int max=Integer.MIN_VALUE;
       int idx=0;
       while(!queue.isEmpty())
       {
           int level=queue.size();
           int min=Integer.MAX_VALUE;int f=0;int l=0;
           for(int i=0;i<level;i++){

         
           Pair<TreeNode,Integer> curr=queue.poll();
           TreeNode node=curr.getKey();
           idx=curr.getValue();
           if(i==0) f=idx;
           if(i==level-1) l=idx;
        
           min=Math.min(min,idx);
           int a=idx-min;
           if(node.left!=null) queue.add(new Pair<>(node.left, 2*a+1 ));
           if(node.right!=null) queue.add(new Pair<>(node.right, 2*a+2));
           }
           max=Math.max(max, l-f+1);

       }
       return max;
    }
}