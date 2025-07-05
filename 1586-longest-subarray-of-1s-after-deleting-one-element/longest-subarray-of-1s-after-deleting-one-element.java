class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;int j=0; int k=1; int max=Integer.MIN_VALUE;
        while(j<nums.length){
           if(nums[j]==0){
            k--;
           }
           if(k>=0){

            max=Math.max(max,j-i+1);
            j++;
           }else{
              max=Math.max(max,j-i);
               if(nums[i]==0){
                k++;
               }
               i++;
               j++;
           }
            
        }
        return max-1;
    }
}