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
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return convertListToBST( 0, res.size()-1);
    }
    TreeNode convertListToBST( int l,int r){
        if(l>r){
            return null;
        }
        int mid=l+(r-l)/2;
        TreeNode newNode=new TreeNode(res.get(mid));
        if(l==r) return newNode;
        newNode.left=convertListToBST( l, mid-1);
        newNode.right=convertListToBST( mid+1, r);

        return newNode;


    }
    ArrayList<Integer> res=new ArrayList<>();
    ArrayList<Integer> inOrder(TreeNode root){
        if(root==null) return null;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
        return res;

    }
}