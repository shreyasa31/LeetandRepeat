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
        int res=Integer.MIN_VALUE; int ans=0;
        queue.add(root); int level=0;
        while(!queue.isEmpty()){
            int maxsum=0;
            level++;
            
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                
                maxsum+=node.val;


              

                 if(node.right!=null){
                    queue.add(node.right);
                }
                  if(node.left!=null){
                    queue.add(node.left);
                }
             

            }



            if(res<maxsum){
                res=maxsum;
                ans=level;
            }

            

        }
        return ans;

    }
}