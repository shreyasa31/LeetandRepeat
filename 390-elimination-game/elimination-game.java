class Solution {
    public int lastRemaining(int n) {
        return solve(n, true);
    }

    int solve(int n, boolean isTurn){
       if(n==1) return 1;


       if(isTurn || n%2!=0){
             return 2 * solve(n/2, !isTurn);
       }else{
            return 2 * solve(n/2, !isTurn)-1;
       }
    }
}