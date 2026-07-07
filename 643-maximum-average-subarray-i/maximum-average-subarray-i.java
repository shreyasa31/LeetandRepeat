class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0;int j=0;
        double sum=0;
        double avg=0;
        double max=Integer.MIN_VALUE;
        
        while(j<nums.length){
            sum+=nums[j];
    
            if(j-i+1<k){
                j++;
      
            }else{
              avg=sum/(j-i+1);
              max=Math.max(max,avg);
              sum-=nums[i];
              avg=avg/nums[i];
              i++;
              j++;
            }
        }
        return max;
    }
}