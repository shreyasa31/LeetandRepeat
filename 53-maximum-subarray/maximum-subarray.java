class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=nums[0];
        int maxS=nums[0];
        for(int i=1;i<nums.length;i++){
          

          currSum=Math.max(currSum+nums[i], nums[i]);
          maxS=Math.max(maxS, currSum);
        }
        return maxS;
    }
}