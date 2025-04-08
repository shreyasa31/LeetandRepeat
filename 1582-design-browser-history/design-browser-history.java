class ListNode{
    String Url;
    ListNode next;
    ListNode prev;
    
    ListNode(String url){
          Url=url;
          prev=null;
          next=null;
    }
}







class BrowserHistory {
     
    ListNode curr;

     
    public BrowserHistory(String homepage) {
        curr=new ListNode(homepage);
       
    }
    
    public void visit(String url) {
        ListNode newNode=new ListNode(url);
        curr.next=newNode;
        newNode.prev=curr;
        curr=curr.next;

    }
    
    public String back(int steps) {

        while(steps>0 && curr.prev != null){
            curr=curr.prev;
            steps--;
        }
        return curr.Url;
    }
    
    
    public String forward(int steps) {
 

        while(steps>0 && curr.next!=null){
            curr=curr.next;
            steps--;
        }
        return curr.Url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */