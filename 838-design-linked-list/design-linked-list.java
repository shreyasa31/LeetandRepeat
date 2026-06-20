class Node{
    int val;
    Node next;
    Node prev;
    Node(int val){
        this.val=val;
        next=null;
        prev=null;
    }
}


class MyLinkedList {
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        head=new Node(0);
        tail=new Node(0);
        head.next=tail;
        tail.prev=head;
        size=0;

    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
         Node curr=head.next;
        int count=0;
   
        while(curr!=null){
            if(count==index){
           
                return curr.val;
                
            }
          
            curr=curr.next;
           
            count++;
             
        }
        return -1;
     
    }
    
    public void addAtHead(int val) {
        
        Node nextNode=head.next;
        Node newNode=new Node(val);
        head.next=newNode;
        newNode.prev=head;
        newNode.next=nextNode;
        nextNode.prev=newNode;
        size++;

       
    }
    
    public void addAtTail(int val) {
        Node prevNode=tail.prev;
        Node newNode=new Node(val);
        prevNode.next=newNode;
        newNode.prev=prevNode;
        newNode.next=tail;
        tail.prev=newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
    if(index < 0) index = 0;
    if(index > size) return;

    Node curr = head.next;
    int count = 0;
    Node newNode = new Node(val);

    while(curr != tail) {
        if(count == index) {
            Node tempprev = curr.prev;

            tempprev.next = newNode;
            newNode.prev = tempprev;

            newNode.next = curr;
            curr.prev = newNode;

            size++;
            return;
        }

        curr = curr.next;
        count++;
    }

    // when index == size, curr is tail
    Node prevNode = tail.prev;

    prevNode.next = newNode;
    newNode.prev = prevNode;

    newNode.next = tail;
    tail.prev = newNode;

    size++;
}
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        Node curr=head.next;
        int count=0;
        // if(size==0) return; 
        while(curr!=tail){
    
        if(count==index){
          Node temp=curr.next;
          
          Node temp2=curr.prev;
          temp2.next=temp;
          temp.prev=temp2;
           size--;

          break;
        }
        curr=curr.next;
        count++;
        }
       

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */