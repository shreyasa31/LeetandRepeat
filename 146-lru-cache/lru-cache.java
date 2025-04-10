class Node{
    Node prev;
    Node next;
    int key;
    int value;
    Node (int key, int val){
        this.key=key;
        value=val;
        prev=null;next=null;
    }
}


class LRUCache {


HashMap<Integer, Node> map;
int size;
Node head; Node tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
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
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node newNode=new Node(key,value);
        addLast(newNode);
        map.put(key,newNode);

        if(map.size()>size){
            map.remove(head.next.key);
            remove(head.next);
           
        }


    }

    void remove(Node node){
         
          
          node.prev.next=node.next;
          node.next.prev=node.prev;

    }
    
    void addLast(Node node){
      Node temp=tail.prev;
      node.next=tail;
      tail.prev=node;  
      temp.next=node;
      node.prev=temp;

    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */