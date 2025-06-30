class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;int prevProfit=0;int min=prices[0]; int sum=0;
        for(int i=0;i<prices.length;i++){
            profit=prices[i]-min;

            if(prevProfit>profit){
               sum+=prevProfit;
               min=prices[i];
               prevProfit=0;
            }else{
                prevProfit=profit;
            }
        }
        sum=sum+prevProfit;
        return sum;
    }
}