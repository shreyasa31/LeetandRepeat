class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode> queue=new LinkedList<>();
       
       queue.add(root);
       List<List<Integer>> res=new ArrayList<>();
       if(root==null) return res;
       int levell=0;
       while(!queue.isEmpty()){
         res.add(new ArrayList<Integer>());

        int level=queue.size();
        for(int  i=0;i<level;i++){
            TreeNode curr=queue.poll();
            res.get(levell).add(curr.val);
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
         levell++;
       }
       return res;
      

    }
}