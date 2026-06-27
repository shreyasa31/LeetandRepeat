/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
 
    public Node lowestCommonAncestor(Node p, Node q) {
     
        Node f=p;
        Node f1=q;
        return solve(p,q, f,f1);
        
    }

    Node solve(Node p, Node q, Node f, Node f1)
    {

        if(p==null){
            p=f1;
            
        }
        if(q==null){
           q=f;
        }
        if(p==q){
            return p;
        }
        return solve(p.parent, q.parent, f, f1);
         
       
    }
}