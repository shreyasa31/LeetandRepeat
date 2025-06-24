class Node{
    Node next,prev;
    int value;
    int key;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
        next=null;
        prev=null;
    }
}






class LRUCache {

    Node tail,head;
    int size; 
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        tail=new Node(0,0);
        head=new Node(0,0);
        map=new HashMap<>();
        size=capacity;
        head.next=tail;
        tail.prev=head;

    }
    
    public int get(int key) {
        if(map.containsKey(key)){
          remove(map.get(key));
          addLast(map.get(key));
          return map.get(key).value;
        }
      
        return  -1;

    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
     
            remove(map.get(key));
        }

        Node newNode=new Node(key,value);
        addLast(newNode);
        map.put(key, newNode);
   

        if(map.size()>size)
        {
            map.remove(head.next.key);
            remove(head.next);
        }

    }

    void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;

    }

    void addLast(Node node){
         Node dummy=tail.prev;
         tail.prev=node;
         node.next=tail;
         node.prev=dummy;
         dummy.next=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */