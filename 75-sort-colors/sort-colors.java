class Solution {
    public void sortColors(int[] nums) {
        int p0=0;int p2=nums.length-1;int curr=0;// curr is for traversal
        while(curr<=p2){
           if(nums[curr]==0){
             int temp=nums[p0];
             nums[p0]=nums[curr];
             nums[curr]=temp;
             p0++;
             curr++;
           }else if(nums[curr]==2){
             int temp2=nums[p2];
             nums[p2]=nums[curr];
             nums[curr]=temp2;
             p2--;
           }else{
            curr++;
           }
        }

    }
}