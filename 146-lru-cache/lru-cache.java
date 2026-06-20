class Node{
    int val;
    Node next;
    Node prev;
    int key;

    Node(int key,int val){
        this.key=key;
        this.val=val;
        next=null;
        prev=null;
    }
}



class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int currSize; int size;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        currSize=0;
        this.size=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;


    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            addLast(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
         Node newNode=new Node(key,value);
     
        if(map.containsKey(key)){
            
              remove(map.get(key));
                map.remove(key);
        }
        
       
        map.put(key, newNode);
        addLast(newNode);

        if(size<currSize){
            map.remove(head.next.key);
            remove(head.next);
        }
        

    }

    void addLast(Node newnode){
        Node temp1=tail.prev;
        tail.prev=newnode;
        newnode.prev=temp1;
        temp1.next=newnode;
        newnode.next=tail;
        currSize++;
       
    }

    void remove(Node node){
        Node temp=node.prev;
        Node nextnode=node.next;
        temp.next=nextnode;
        nextnode.prev=temp;
        currSize--;


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */