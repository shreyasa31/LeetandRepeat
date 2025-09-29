import java.util.*;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        nodes.push(root);
        sums.push(root.val);
        parent.put(root, null);

        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pop();
            int curSum = sums.pop();

            // if leaf and sum matches, rebuild the path using parent links
            if (cur.left == null && cur.right == null && curSum == targetSum) {
                List<Integer> path = new ArrayList<>();
                for (TreeNode x = cur; x != null; x = parent.get(x)) {
                    path.add(x.val);
                }
                Collections.reverse(path);
                res.add(path);
            }

            if (cur.right != null) {
                parent.put(cur.right, cur);
                nodes.push(cur.right);
                sums.push(curSum + cur.right.val);
            }
            if (cur.left != null) {
                parent.put(cur.left, cur);
                nodes.push(cur.left);
                sums.push(curSum + cur.left.val);
            }
        }
        return res;
    }
}
