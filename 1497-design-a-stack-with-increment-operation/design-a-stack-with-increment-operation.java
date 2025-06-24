class CustomStack {
    int[] array; int size;int i;
    public CustomStack(int maxSize) {
        array=new int[maxSize];
        size=maxSize;    
        i=0;
    }
    
    public void push(int x) {
    
        if(i<size){
            array[i]=x;
            i++;
        }
    }
    
    public int pop() {
        if(i==0){
           return -1;
        }
        i--;
        return array[i];
    }
    
    public void increment(int k, int val) {
        for(int j=0;j<Math.min(k,i);j++){
            array[j]+=val;
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