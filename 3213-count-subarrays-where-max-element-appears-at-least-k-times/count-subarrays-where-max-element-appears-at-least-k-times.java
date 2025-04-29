class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Integer.MIN_VALUE; long res=0;
        for(int num:nums){
           max=Math.max(max, num);
        }

        int i=0;int j=0; int count=0;
        while(j<nums.length){
            if(nums[j]==max){
                count++;
            }
          
            while(count>=k){
                res+=(nums.length-j);
                if( nums[i]==max){
                    count--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}