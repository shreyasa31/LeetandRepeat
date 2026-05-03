class ListNode
{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
class MyCircularQueue {
    int size; int cursize;
    ListNode head,tail;
    public MyCircularQueue(int k) {
       head=null;
       tail=null;
       size=k;
       cursize=0;
    }
    
    public boolean enQueue(int value) {
        ListNode newNode=new ListNode(value);
        if(isFull()) return false;
        if(isEmpty()){
            head=tail=newNode;
            tail.next=head;

        }else{
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
        }
        cursize++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(cursize==1){
            head=tail=null;
        }else{
            head=head.next;
            tail.next=head;
        }
        cursize--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return cursize==0;
    }
    
    public boolean isFull() {
        return cursize==size;
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