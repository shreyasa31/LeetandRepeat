class Solution {
    public long maximumTripletValue(int[] nums) {
        //max value, max diff, max multiply


       long result=0;
        long diff=Integer.MIN_VALUE;
        long maxNumber=nums[0];
        for(int i=1;i<nums.length-1;i++){
          diff=Math.max(diff, maxNumber-nums[i]);
          long mul=diff*nums[i+1];
          result=Math.max(result, mul);
          maxNumber=Math.max(maxNumber,nums[i]);

        }

        return result;


    }
}