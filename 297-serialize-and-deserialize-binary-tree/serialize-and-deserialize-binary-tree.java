/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         Queue<TreeNode> queue=new LinkedList<>();
         queue.add(root);
         StringBuilder sb=new StringBuilder();
         while(!queue.isEmpty()){
            int level=queue.size();
            for(int i=0;i<level;i++){
                TreeNode node=queue.poll();
                if(node==null){
                    sb.append("null ");
                    continue;
                }
                sb.append(node.val+" ");
                queue.add(node.left);
                queue.add(node.right);
                
            }
         }
         System.out.println(sb.toString());
         return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] d=data.split(" ");
        if(d[0].equals("null")) return null;
        Queue<TreeNode> queue=new LinkedList<>();
 
        int r=Integer.parseInt(d[0]);

        TreeNode root=new TreeNode(r);
        queue.add(root);
        int i=1;
        while(!queue.isEmpty() && i<d.length){
            TreeNode p=queue.poll();
            if(!d[i].equals("null")){

            
             int number=Integer.parseInt(d[i]);
             TreeNode leftNode=new TreeNode(number);
             p.left=leftNode;
             queue.add(leftNode);}
             i++;
             if(!d[i].equals("null")){
             int number1=Integer.parseInt(d[i]);
             TreeNode rightNode=new TreeNode(number1);
             p.right=rightNode;
             queue.add(rightNode);}
             i++;


        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));