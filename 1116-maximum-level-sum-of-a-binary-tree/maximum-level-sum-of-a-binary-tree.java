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
        queue.add(root);int max=Integer.MIN_VALUE;int resultl=1;  int k=1;
        while(!queue.isEmpty()){
          
            int level=queue.size();
            int sum=0;
            for(int i=0;i<level;i++){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            
        
            if(max<sum){
                 resultl=k;
                 max=sum;
            }
            k++;
            

        }
        return resultl;
    }
}