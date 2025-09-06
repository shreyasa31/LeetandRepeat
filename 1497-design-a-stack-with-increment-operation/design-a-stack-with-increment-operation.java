class CustomStack {
    int[] res;int i; int size;
    public CustomStack(int maxSize) {
        res=new int[maxSize];
        i=0;
        size=maxSize;
    }
    
    public void push(int x) {
    
        if(i<size){
        res[i]=x;
        i++;
        }
     

    }
    
    public int pop() {
        if(i==0) return -1;
        i--;
        return res[i];

    }
    
    public void increment(int k, int val) {
        for(int j=0;j<Math.min(k,i);j++){
            res[j]=res[j]+val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */