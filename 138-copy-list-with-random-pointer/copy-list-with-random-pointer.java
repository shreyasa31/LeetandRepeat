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
        Node curr=head;
        //copying the node and making connections
        while(curr!=null){
            Node node=new Node(curr.val);
            Node temp=curr.next;
            curr.next=node;
            node.next=temp;
            curr=temp;
             
        }

        //connecting the random pointers

        curr=head;
        while(curr!=null){
            curr.next.random=(curr.random!=null)?curr.random.next:null;
            curr=curr.next.next;
        }

        //Remove connection and put it back
        if(head==null) return null;
        Node oldNode=head;
        Node newNode=oldNode.next;
        Node newHead=newNode;
        while(oldNode!=null){
            oldNode.next=newNode.next;
            newNode.next=(newNode.next!=null)?newNode.next.next:null;
            oldNode=oldNode.next;
            newNode=newNode.next;
        }
        return newHead;
    }
}