class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;int j=0; int g=0;
        int max=Integer.MIN_VALUE;
        while(j<nums.length){
            
            if(nums[j]==0){
                g++;
            }
            if(g<=k){
                max=Math.max(max,j-i+1);
                j++;
            }else{
                max=Math.max(max,j-i);
                if(nums[i]==0){
                    g--;
                }
                i++;
                j++;
            }
        }
        return max;
    }
}