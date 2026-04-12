/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map=new HashMap<>();
        parentMap(root, map,null);
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();

        queue.add(target);
        visited.add(target);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(level==k){
                while(!queue.isEmpty()){
                    ans.add(queue.poll().val);
            }
            return ans;
            }
            for(int i=0;i<size;i++)
            {
                 TreeNode curr=queue.poll();
                 
                 if(curr.left!=null && !visited.contains(curr.left)){
                        visited.add(curr.left);
                        queue.add(curr.left);
                 }
                 if(curr.right!=null && !visited.contains(curr.right)){
                        visited.add(curr.right);
                        queue.add(curr.right);
                 }
                 TreeNode parent=map.get(curr);
                 if(parent!=null && !visited.contains(parent)){
                        visited.add(parent);
                        queue.add(parent);
                 }
            }
            level++;
        }
return ans;
    }
    void parentMap(TreeNode root, HashMap<TreeNode, TreeNode> map, TreeNode parent ){
        if(root==null) return;
        map.put(root, parent);
        parentMap(root.left, map,root);
        parentMap(root.right, map, root);

      
    }

    
}