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
        solve(head);
        return head;
    }
    public Node solve(Node head) {
        Node curr=head; Node tail=curr;
        while (curr!=null) {
            Node curr1=curr.next;
            tail=curr;
            if(curr.child!=null){
             Node chld=curr.child;
             Node childTail=solve(chld);
             curr.next=chld;
             chld.prev=curr;
             curr.child=null;
            //  while(chld.next!=null){
            //     chld=chld.next;
            //  }
             childTail.next=curr1;
             if(curr1!=null)
             curr1.prev=childTail;
             tail=childTail;
            }
             curr=curr.next;
        }
        return tail;
    }
}