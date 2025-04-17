class Solution {
    public int  countPairs(int[] nums, int k) {
          int i=0;
          int count=0;

          while(i<nums.length){
                     int j=i+1;
                     while(j<nums.length){
                        if(nums[i]==nums[j] && ((i*j)%k==0)){
                            count++;
                        }
                        j++;
                     }
                     i++;
          }
          return count;
    }
}