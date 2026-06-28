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
 class Pair<K,R, V>{
    K key;
    R row;
    V column;
    Pair(K k, R r, V v){
        key=k;
        row=r;
        column=v;
    }


 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair<TreeNode, Integer, Integer>> queue=new LinkedList<>();

        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
        queue.add(new Pair<>(root, 0,0));
        int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
             Pair<TreeNode, Integer,Integer> node=queue.poll();
             TreeNode key=node.key;
             int row=node.row;
             int col=node.column;
             if(!map.containsKey(col) && key!=null)
             map.put(col, new ArrayList<>());
             map.get(col).add(new int[]{row,key.val});
             min=Math.min(col, min);
             max=Math.max(col,max);
             if(key.left!=null){
                queue.add(new Pair<>(key.left,row+1,col-1));
             }
             if(key.right!=null){
                queue.add(new Pair<>(key.right,row+1,col+1));
             }
        }
        System.out.println(min+" "+max);
        for(int i=min;i<=max;i++){
            Collections.sort(map.get(i),(a,b)->{
                if(a[0]!=b[0]){
                    return a[0]-b[0];

                }
                return a[1]-b[1];
            });
           List<Integer> columnList = new ArrayList<>();

            for (int[] pair : map.get(i)) {
                columnList.add(pair[1]);
            }

            res.add(columnList);
        
        
        }
return res;
    }
}