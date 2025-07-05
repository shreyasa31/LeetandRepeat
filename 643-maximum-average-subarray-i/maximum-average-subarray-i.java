class Solution {
    public double findMaxAverage(int[] nums, int k){
        int i=0;int j=0; double avg=1;
       double max=Double.NEGATIVE_INFINITY; double sum=0;
        while(j<nums.length){
           sum=sum+nums[j];
           avg=sum/(j-i+1);
           if(j-i+1<k){
            j++;
           }else{
              max=Math.max(max,avg);
              sum=sum-nums[i];
              i++;
              
              if( i<nums.length){
                avg=sum/(j-i+1);
              }
           
             j++;
          
               

           }
        }
        return max;
    }
}