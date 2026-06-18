class Solution {
    public int lastRemaining(int n) {
        return turns(n,true);
    }

    int turns(int n, boolean isTurn){
        if(n==1) return 1;

        if(isTurn || n%2!=0){
            return 2* turns(n/2, !isTurn);
        }else
        {
            return 2* turns(n/2, !isTurn)-1;
        }
    }
}