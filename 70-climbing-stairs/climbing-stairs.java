class Solution {
    public int climbStairs(int n) {
        // int dp[]=new int[n+1];
        // Arrays.fill(dp, -1);
        if(n<=2) return n;

        // if(dp[n]!=-1) return dp[n];
        // return dp[n]=climbStairs(n-1)+climbStairs(n-2);

        int prev=1;
        int prev2=2; 
        int curr=0;
        for(int i=2;i<n;i++){
            curr=prev+prev2;
            int temp=prev2;
            prev2=curr;
            prev=temp;
            
        }
        return curr;
    }
}