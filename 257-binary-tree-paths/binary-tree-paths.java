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
   
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
       
       return Paths(root, sb, res);
    }
     List<String> Paths(TreeNode root, StringBuilder s,ArrayList<String> res ){
        if(root==null){
           return res;
            
        }
        int l=s.length();
        if(l!= 0){
    s.append("->");
}
        s.append(root.val);
      
       if(root.left==null && root.right==null)
       {
          res.add(s.toString());
     
       }
 

        Paths(root.left, s, res);
        Paths(root.right, s, res);
        
        s.setLength(l);
        return res;
    }
}