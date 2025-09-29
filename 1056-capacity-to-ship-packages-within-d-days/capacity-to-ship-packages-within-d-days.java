class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;int high=0;
        for(int num:weights){
            low=Math.max(low,num);
            high+=num;
        }
       int min=0;
        while(low<=high){
            int mid=low+(high-low)/2;

            int requireddays=1;
            int sum=0;

           for(int w:weights){
               sum+=w;
               if(sum>mid){
                requireddays++;
                sum=w;
               }
              
             
           }
            if(requireddays<=days){
                min=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return min;
    }
}