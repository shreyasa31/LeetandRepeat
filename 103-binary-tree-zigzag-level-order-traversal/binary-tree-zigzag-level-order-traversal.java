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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // result list to hold all levels
        List<List<Integer>> result = new ArrayList<>();

        // if root is null return empty result
        if (root == null) return result;

        // queue for standard level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // start with the root in the queue
        queue.offer(root);

        // direction flag true means left to right false means right to left
        boolean leftToRight = true;

        // process until the queue is empty
        while (!queue.isEmpty()) {
            // number of nodes in the current level
            int size = queue.size();

            // list to store values of this level
            List<Integer> level = new ArrayList<>(size);

            // take exactly size nodes from the queue
            for (int i = 0; i < size; i++) {
                // get next node from the queue
                TreeNode node = queue.poll();

                // add its value to this level list
                level.add(node.val);

                // push left child to queue if it exists
                if (node.left != null) queue.offer(node.left);

                // push right child to queue if it exists
                if (node.right != null) queue.offer(node.right);
            }

            // if this level should be right to left reverse the collected list
            if (!leftToRight) Collections.reverse(level);

            // add the level to the final result
            result.add(level);

            // flip direction for the next level
            leftToRight = !leftToRight;
        }

        // return the zigzag level order traversal
        return result;
    }
}
