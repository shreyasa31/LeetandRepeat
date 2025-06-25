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
        if(head==null) return null;
        while(curr!=null){ //copying next pointers like zigzag fashion creating clones
            Node node=new Node(curr.val);
            Node temp=curr.next;
            curr.next=node;
            node.next=temp;
            curr=temp;
        }
        

        //copying random pointers
        curr=head;
        while(curr!=null){
            curr.next.random=(curr.random==null)?null: curr.random.next;
            curr=curr.next.next;
        }
        
        //remove all the connections so that we can separate the two copies

        Node oldNode=head;
        Node newNode=oldNode.next;
        Node newHead=newNode;
        while(oldNode!=null){
            oldNode.next=newNode.next;
            newNode.next=newNode.next==null?null:newNode.next.next;
            oldNode=oldNode.next;
            newNode=newNode.next;
        }

        return newHead;

    }
}