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
    // Path Sum III using an iterative DFS with prefix sums
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // prefix sum frequency map
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(0L, 1);                   // empty prefix

        // stacks for nodes, running sums on the path to the node, and a visited flag
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Long> sums = new Stack<>();
        Stack<Boolean> visited = new Stack<>();

        nodes.push(root);
        sums.push(0L);                     // parent sum before including root
        visited.push(false);

        long total = 0;

        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pop();
            long parentSum = sums.pop();
            boolean seen = visited.pop();

            if (cur == null) continue;

            if (!seen) {
                // first time we see this node  enter
                long curSum = parentSum + cur.val;

                // count paths that end at this node
                total += freq.getOrDefault(curSum - targetSum, 0);

                // record this prefix sum
                freq.put(curSum, freq.getOrDefault(curSum, 0) + 1);

                // push a marker to backtrack later
                nodes.push(cur);
                sums.push(curSum);
                visited.push(true);

                // go to children passing the current sum
                if (cur.right != null) {
                    nodes.push(cur.right);
                    sums.push(curSum);
                    visited.push(false);
                }
                if (cur.left != null) {
                    nodes.push(cur.left);
                    sums.push(curSum);
                    visited.push(false);
                }
            } else {
                // leaving the node  remove its prefix sum from the map
                freq.put(parentSum, freq.get(parentSum) - 1);
            }
        }

        return (int) total;
    }
}
