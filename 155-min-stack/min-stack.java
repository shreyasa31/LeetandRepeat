class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> minStack;
    public MinStack() {
        stack1=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        stack1.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);

        }else{
            minStack.push(minStack.peek());
        }

    }
    
    public void pop() {
       stack1.pop();
       minStack.pop();

    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */