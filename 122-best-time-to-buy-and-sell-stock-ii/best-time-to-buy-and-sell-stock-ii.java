class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0]; int max=0; int count=0;
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }else{
                max+=prices[i]-min;
                min=prices[i];
            }
        }

        return max;
    }
}