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
    HashMap<Integer, List<Integer>> map=new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        
      List<List<Integer>> ans=new ArrayList<>();
      height(root);
      int i=1;
      while(map.containsKey(i)){
        ans.add(map.get(i));
        i++;
      }
      return ans;

    }
    
     int height(TreeNode root){
        if(root==null) return 0;


      
        int left=height(root.left);
        int right=height(root.right);
        int h= Math.max(left, right)+1;

        if(!map.containsKey(h)){
            map.put(h, new ArrayList<>());

        }
        map.get(h).add(root.val);
        return h;
    }
}