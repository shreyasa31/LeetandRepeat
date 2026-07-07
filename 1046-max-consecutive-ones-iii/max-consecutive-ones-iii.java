class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;int j=0;
       int max=Integer.MIN_VALUE;
        while(j<nums.length)
        {
            if(nums[j]==0) k--;
            if(k>=0)
            {
                       max=Math.max(max, j-i+1);
                j++;
                
            }else{

        
               if(nums[i]==0) k++;
               i++;
               j++;
            }

        }
        return max==Integer.MIN_VALUE?0:max;
    }
}