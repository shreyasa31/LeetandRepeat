class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}


class MyCircularQueue {
    Node head, tail;
    int size; int currsize;
    public MyCircularQueue(int k) {
        head=null;
        tail=null;
        this.size=k;
        currsize=0;
    }
    
    public boolean enQueue(int value) {
       if(isFull()) return false;
       Node newNode=new Node(value);
       if(isEmpty()){ 

        head=tail=newNode;
        tail.next=head;

       }else{
             tail.next=newNode;
             tail=tail.next;
             tail.next=head;
       }
       currsize++;
       return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        if(currsize==1){
            head=tail=null;
        }else{
            head=head.next;
            tail.next=head;
        }
        currsize--;
        return true;
        

    }
    
    public int Front() {
       if(isEmpty())return -1;
       return head.val;
    }
    
    public int Rear() {
      if(isEmpty()) return -1;
       return tail.val;
    }
    
    public boolean isEmpty() {
        return currsize==0;
    }
    
    public boolean isFull() {
        return size==currsize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */