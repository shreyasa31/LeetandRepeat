class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans=new int[nums.length*2];
        int j=0;
        for(int i=0;i<ans.length/2;i++){
            ans[i]=nums[j];
            ans[i+nums.length]=nums[j];
            j++;
        }
        return ans;
    }
}