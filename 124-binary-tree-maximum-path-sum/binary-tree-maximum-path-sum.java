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
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> gainMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        int maxSum = Integer.MIN_VALUE;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            boolean canProcess = true;

            if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
                canProcess = false;
            }

            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                canProcess = false;
            }

            if (canProcess) {
                stack.pop();
                visited.add(node);

                int leftGain = Math.max(0, gainMap.getOrDefault(node.left, 0));
                int rightGain = Math.max(0, gainMap.getOrDefault(node.right, 0));

                int localMax = node.val + leftGain + rightGain;
                maxSum = Math.max(maxSum, localMax);

                // Store the max gain to propagate upward
                gainMap.put(node, node.val + Math.max(leftGain, rightGain));
            }
        }

        return maxSum;
    }
}
