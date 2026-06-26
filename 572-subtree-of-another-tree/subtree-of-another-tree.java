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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        String first=inOrder(root,new StringBuilder());

        String second=inOrder(subRoot,new StringBuilder());
        return first.contains(second);
    }
   
String inOrder(TreeNode root, StringBuilder sb) {
    if (root == null) {
        sb.append("null");
        return sb.toString();
    }

    sb.append("^");
    inOrder(root.left, sb);
    sb.append(root.val);
    inOrder(root.right, sb);
    return sb.toString();
}
}