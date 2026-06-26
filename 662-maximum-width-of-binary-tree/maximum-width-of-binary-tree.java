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
        Queue<Pair<TreeNode, Integer>> queue=new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        int idx=0; 
        int max=Integer.MIN_VALUE;
        int f=0;int l=0;
        while(!queue.isEmpty()){

            int level=queue.size();
            int min=Integer.MAX_VALUE;
            for(int i=0;i<level;i++){
                Pair<TreeNode, Integer> p=queue.poll();
                TreeNode key=p.getKey();
                idx=p.getValue();

                if(i==0) f=idx;
                if(i==level-1) l=idx;

                min=Math.min(min,idx);

                int a= idx-min;
                if(key.left!=null){
                    queue.add(new Pair<>(key.left, 2*a+1));
                }
                if(key.right!=null){
                    queue.add(new Pair<>(key.right, 2*a+2));
                }

                


            }
            max=Math.max(max, l-f+1);
           

        }
        return max;
    }
}