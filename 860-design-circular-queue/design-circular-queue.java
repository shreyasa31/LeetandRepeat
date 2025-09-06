class Node{
    Node next;
    int val;
    Node(int val){
        this.val=val;
        next=null;
    }
}


class MyCircularQueue {
   Node front,rear;
   int size; int currsize;
    public MyCircularQueue(int k) {
       front=null;
       rear=null;
       size=k;
       currsize=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        Node newnode=new Node(value);
        if(isEmpty()){
            front=rear=newnode;
            rear.next=front;
        }else{
            rear.next=newnode;
            rear=newnode;
            rear.next=front;
        }
        currsize++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
          if(front==rear) 
        {
            front=rear=null;
        }else{

        
        front=front.next;
        rear.next=front;}
        currsize--;
        return true;

    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return front.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return rear.val;
    }
    
    public boolean isEmpty() {
        return currsize==0;
    }
    
    public boolean isFull() {
        return currsize==size;
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