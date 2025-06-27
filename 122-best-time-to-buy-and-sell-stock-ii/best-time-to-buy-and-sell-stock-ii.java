class Solution {
    public int maxProfit(int[] prices) {
        int prevProfit=0;
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            int profit=prices[i]-min;

            if(profit<prevProfit){
               max+=prevProfit;
               min=prices[i];
               prevProfit=0;
            }else{
                prevProfit=profit;
            }
        }
        max+=prevProfit;
        return max;
    }
}