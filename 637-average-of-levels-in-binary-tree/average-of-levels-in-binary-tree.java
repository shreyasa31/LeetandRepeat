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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Double> list = new ArrayList<>();
        while (!queue.isEmpty()) {

            double sum = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {

                root = queue.poll();

                sum = sum + root.val;
                if (root.right != null) {
                    queue.add(root.right);
                }
                if (root.left != null) {
                    queue.add(root.left);
                }

            }

            list.add(sum / n);
        }

        return list;

    }
}