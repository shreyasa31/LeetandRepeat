/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        if(node==null) return node;
        map.put(node, new Node(node.val));
        queue.add(node);

        while(!queue.isEmpty()){
            Node n=queue.poll();

            for(Node nei: n.neighbors)
            {
                if(!map.containsKey(nei)){
                map.put(nei, new Node(nei.val));
                queue.add(nei);}
                map.get(n).neighbors.add(map.get(nei));
             
            }
          
        }
        
        return map.get(node);
    }
}