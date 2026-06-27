/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
        while (curr!=null) {
            Node curr1=curr.next;
            if(curr.child!=null){
             Node chld=curr.child;
             curr.next=chld;
             chld.prev=curr;
             curr.child=null;
             while(chld.next!=null){
                chld=chld.next;
             }
             chld.next=curr1;
             if(curr1!=null)
             curr1.prev=chld;
            }
             curr=curr.next;
        }
        return head;
    }
}