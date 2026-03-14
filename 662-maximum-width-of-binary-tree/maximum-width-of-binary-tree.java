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
//  class Pair{
//     TreeNode t;
//     int val
//     Pair(TreeNode t, int val){
//         this.t=t;
//         this.val=val;
//     }
//  }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue=new LinkedList<>();
        int max=Integer.MIN_VALUE;
        queue.add(new Pair<>(root,0));
        while(!queue.isEmpty()){
           
           int minidx=queue.peek().getValue();
           int first=0;int last=0;
           int l=queue.size();
           for(int i=0;i<l;i++){
            Pair<TreeNode, Integer> curr=queue.poll();
            int curridx=curr.getValue();
            int next=curridx-minidx;
            if(i==0) first=curridx;
            if(i==l-1) last=curridx;
            TreeNode currNode=curr.getKey();
            if(currNode.left!=null){
                queue.add(new Pair<>(currNode.left, (2*next)+1));
            }
             if(currNode.right!=null){
                queue.add(new Pair<>(currNode.right, (2*next)+2));
            }
           }
           max=Math.max(max, (last-first+1));

        }
        return max;

    }
}