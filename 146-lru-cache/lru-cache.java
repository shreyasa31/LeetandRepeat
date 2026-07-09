class DLL{
    DLL next;
    DLL prev;
    int key;
    int val;
    DLL(int key,int val){
        this.key=key;
        this.val=val;
    }
}




class LRUCache {
    DLL head;
    DLL tail;
    int currSize;
    int size;
    HashMap<Integer, DLL> map;
    public LRUCache(int capacity) {
        this.size=capacity;
        currSize=0;
        head=new DLL(0, 0);
        tail=new DLL(0, 0);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
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
        
        if(map.containsKey(key)){
             remove(map.get(key));
             map.remove(key);
            
        }


        DLL newNode=new DLL(key, value);
        map.put(key, newNode);
        addLast(newNode);

        if(currSize>size){
         
          map.remove(head.next.key);
               remove(head.next);
        
          
        }
    }

    void addLast(DLL node){
       DLL temp=tail.prev;
       temp.next=node;
       node.prev=temp;
       node.next=tail;
       tail.prev=node;
       currSize++;
    }

    void remove(DLL node){
   
      DLL prevNode = node.prev;
    DLL nextNode = node.next;

    prevNode.next = nextNode;
    nextNode.prev = prevNode;

      currSize--;
    }
   
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */