class Solution {
    int MAX= 1000000007;
    public int countGoodNumbers(long n) {
       
    
    return (int)((solve(5, (n+1)/2) * solve (4, n/2)) % MAX);

       
    }

    long solve( long n, long index){
        if(index==0) return 1;
        if(index==1) return n;
       
        if(index%2==0){
          return solve((n*n)%MAX, index/2);
        }
        else{
           return (n*solve((n*n)%MAX, index/2))%MAX;
        }
        
    
    }
}