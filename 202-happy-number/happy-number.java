class Solution {
    public boolean isHappy(int n) {

        while(n!=1 && n!=4){
            int squares=0;
            while(n>0){
          
            int rem=n%10;
            squares+=(rem*rem);
            n=n/10;
           }
            n=squares;
        }
        return n==1;
    }
}