class Solution {
    long MAX=1000000007;
    public int countGoodNumbers(long n) {
        
        if(n==0) return 1;
        return(int)((solve(5, (n+1)/2) *  solve(4,n/2))%MAX);
    }

     long solve(long x, long n){
        if(n==0) return 1;
        if(n==1) return x;

        if(n%2==0){
            return solve((x*x)%MAX, n/2);
        }else{
            return (x*solve((x*x)%MAX,n/2))%MAX;
        }
     }
}
