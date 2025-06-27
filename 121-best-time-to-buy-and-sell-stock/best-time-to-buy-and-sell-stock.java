class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
             if(min>prices[i]){
                min=prices[i];
             }
            
             int profit=Math.abs(prices[i]-min);
             max=Math.max(max,profit);
             
        }
        return max;
    }
}