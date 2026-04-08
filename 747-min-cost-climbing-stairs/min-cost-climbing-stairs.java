class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
             int dp[]=new int[n+1];
             Arrays.fill(dp,-1);
        return minCost(n, cost,dp);
        

    }
    int minCost(int n, int[] cost, int[] dp){
     
   
        if(n==0 || n==1)  return 0;
        if(dp[n]!=-1) return dp[n];
        int prevsum=minCost(n-1, cost, dp)+cost[n-1];
        int prevsum1=Integer.MAX_VALUE;
        if(n>1)
        prevsum1=minCost(n-2, cost,dp)+cost[n-2];

        return dp[n]=Math.min(prevsum,prevsum1);
    }
}