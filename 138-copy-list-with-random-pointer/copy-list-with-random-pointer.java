/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            Node temp=curr.next;
            curr.next=newNode;
            newNode.next=temp;
            curr=temp;
        }

        curr=head;
        while(curr!=null){
            curr.next.random=(curr.random==null)?null:curr.random.next;
            curr=curr.next.next;
        }
        
        Node oldHead=head;
        Node newHead=oldHead.next;
        Node curr1=newHead;
        while(oldHead!=null){
 
            oldHead.next=curr1.next;
            oldHead=oldHead.next;
            curr1.next=(curr1.next==null)?null:oldHead.next;
            curr1=curr1.next;
        }
        return newHead;
    }
}