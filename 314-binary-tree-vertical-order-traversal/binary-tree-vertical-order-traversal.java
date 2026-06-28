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
  public List<List<Integer>> verticalOrder(TreeNode root) {
    Queue<Pair<TreeNode, Integer>> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        queue.add(new Pair<>(root, 0));
        int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
             Pair<TreeNode, Integer> node=queue.poll();
             TreeNode key=node.getKey();
             int value=node.getValue();
             if(!map.containsKey(value) && key!=null)
             map.put(value, new ArrayList<>());
             map.get(value).add(key.val);
             min=Math.min(value, min);
             max=Math.max(value,max);
             if(key.left!=null){
                queue.add(new Pair<>(key.left,value-1));
             }
             if(key.right!=null){
                queue.add(new Pair<>(key.right,value+1));
             }
        }
    
        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                 
                 res.add(map.get(i));
                 
            }
        }
        return res;
  }
}