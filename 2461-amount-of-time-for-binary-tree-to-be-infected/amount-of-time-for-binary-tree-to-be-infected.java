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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, Set<Integer>> map=new HashMap<>();
        convert(root, 0, map);

        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{start,0});
        HashSet<Integer> set=new HashSet<>();
        set.add(start); int max=0;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int node=curr[0];
            int d=curr[1];
           max=Math.max(max, d);
            for(int n:map.get(node)){
                
            
                if(!set.contains(n)){
                    set.add(n);
                    queue.add(new int[]{n,d+1});
                }
            }
            
            
        }  
           
           return max;
           
           
     }
    void convert(TreeNode root, int parent, HashMap<Integer, Set<Integer>> map){
           
           if(root==null) return;

           if(!map.containsKey(root.val)){
            map.put(root.val, new HashSet<>());
           }

           Set<Integer> adjList=map.get(root.val);

           if(parent!=0){
                adjList.add(parent);
           }

            if(root.left!=null){
                adjList.add(root.left.val);
           }

            if(root.right!=null){
                adjList.add(root.right.val);
           }

           convert(root.left, root.val, map);
           convert(root.right, root.val, map);

    }
}