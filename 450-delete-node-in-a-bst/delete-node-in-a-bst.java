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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            return helper(root);
        }

        TreeNode cur = root;

        while (cur != null) {
            if (key < cur.val) {
                if (cur.left != null && cur.left.val == key) {
                    cur.left = helper(cur.left);
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right != null && cur.right.val == key) {
                    cur.right = helper(cur.right);
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    // returns the subtree that should replace node after deletion
    private TreeNode helper(TreeNode node) {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        TreeNode rightChild = node.right;
        TreeNode lastRight = findLastRight(node.left);
        lastRight.right = rightChild;
        return node.left;
    }

    private TreeNode findLastRight(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }
}
