class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
    
   
        List<TreeNode> p1 = getPath(root, p);
        List<TreeNode> p2 = getPath(root, q);

        // Compare the paths to find the split point (LCA)
        int i;
        for (i = 0; i < p1.size() && i < p2.size(); i++) {
            if (!p1.get(i).equals(p2.get(i))) {
                break;
            }
        }

        // Return the last common node before the paths diverge
        return p1.get(i - 1);

    
        
    }

    List<TreeNode> getPath(TreeNode root, TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        HashMap<TreeNode, TreeNode> map=new HashMap<>();
   
        stack.add(root);
        map.put(root,null);

        while(!stack.isEmpty()){
            root=stack.pop();
            // if(root==node) break;
            if(root.left!=null){
               stack.push(root.left);
               map.put(root.left, root);
            }

            if(root.right!=null){
               stack.push(root.right);
               map.put(root.right, root);
            }



            
           
    
        }
        ArrayList<TreeNode> path=new ArrayList<>();
            while(node!=null)
            {
                path.add(node);
                node=map.get(node);
            }
         Collections.reverse(path);
         return path;
    }
}
