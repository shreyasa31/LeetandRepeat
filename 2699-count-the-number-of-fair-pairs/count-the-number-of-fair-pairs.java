class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
           int left=0;int right=nums.length-1;

           long upperCount=0;
           Arrays.sort(nums);
           while(left<right){
            if(nums[left]+nums[right]<=upper){
                upperCount+=(right-left);
                left++;
            }else{
                right--;
            }
           }
    
       

            left=0; right=nums.length-1;

           long lowerCount=0;
           while(left<right){
            if(nums[left]+nums[right]<lower){
                lowerCount+=(right-left);
                left++;
            }else{
                right--;
            }
           }
           return upperCount-lowerCount;
    }
}