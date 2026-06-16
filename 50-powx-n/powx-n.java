class Solution {
    public double myPow(double x, long n) {
        if(n==0) return (double)1;
        if(n==1) return x;

        if(n<0){
            x=1/x;
            n=-n;
        }

        // return x * myPow(x, n-1);

        if(n%2==0){
            return myPow(x*x, n/2);
        }else{
          return  x * myPow(x*x, n/2);
        }
    }
}