
import java.util.stream.Gatherer.Integrator;/**
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
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        convert(root, null, map);
        HashSet<TreeNode> set=new HashSet<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(target);
        set.add(target);
       int level=0;
        while(level<k && !queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                 TreeNode curr=queue.poll();
                 if(curr.left!=null && !set.contains(curr.left)){
                    set.add(curr.left);
                    queue.add(curr.left);
                 }
                 if(curr.right!=null && !set.contains(curr.right)){
                    set.add(curr.right);
                    queue.add(curr.right);
                 }
                 TreeNode parent=map.get(curr);
                 if(parent!=null && !set.contains(parent)){
                    set.add(parent);
                    queue.add(parent);
                 }
            }
            level++;
        }
       
        ArrayList<Integer> res=new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll().val);
            
        }
        return res;
    }
    void convert(TreeNode root,TreeNode parent, HashMap<TreeNode, TreeNode> map){
           if(root==null) return;
           map.put(root, parent);
           convert(root.left, root, map);
           convert(root.right, root, map);
    }
}