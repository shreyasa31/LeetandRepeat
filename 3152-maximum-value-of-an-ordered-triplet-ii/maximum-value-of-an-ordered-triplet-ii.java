class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxNumber=nums[0];
        long diff=0;long result=0;
        for(int i=1;i<nums.length-1;i++){
            diff=Math.max(diff, maxNumber-nums[i]);
            long mul=diff*nums[i+1];
            result=Math.max(result,mul);
            maxNumber=Math.max(maxNumber,nums[i]);

        }
        return result;
    }
}