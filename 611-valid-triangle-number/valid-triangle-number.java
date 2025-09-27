class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);          // sort so values are nondecreasing
    int n = nums.length;
    int count = 0;

    for (int k = n - 1; k >= 2; k--) {     // treat nums[k] as largest side
        int i = 0;                         // smallest side index
        int j = k - 1;
            while(i<j){
            
                if(nums[i]+nums[j]>nums[k]){
                    count+=(j-i);
                    j--;
                
                }else{
                    i++;
                }

            }
           
        }
        return count;
    }
}