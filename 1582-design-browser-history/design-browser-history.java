class Node{
    String value;
    Node next;
    Node prev;
    Node(String value){
        this.value=value;
        next=null;
        prev=null;
    }
}


class BrowserHistory {
     
    Node curr;
    
    public BrowserHistory(String homepage) {
        curr=new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode=new Node(url);
        curr.next=newNode;
        newNode.prev=curr;
        curr=curr.next;
    }
    
    public String back(int steps) {
        int x=0;
       
        
        while(curr.prev!=null && x<steps){
            curr=curr.prev;
            x++;
        }
        return curr.value;
    }
    
    public String forward(int steps) {
        int x=0;
        while(curr.next!=null && x<steps){
            curr=curr.next;
            x++;
        }
        return curr.value;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */