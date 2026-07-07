class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int i=0;int j=0;long sum=0; int max1=0;
        while(j<nums.length){
            sum+=nums[j];
            if((long)nums[j]*(j-i+1)-sum<=k){
                max1=Math.max(j-i+1, max1);
              j++;
            }else{
               sum-=nums[i];
               i++;
               j++;
            }
        }
        return max1;
        
    }
}