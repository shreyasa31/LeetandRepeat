class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0; int i=0;
        while(j<nums.length){
            if(nums[j]==val){
                j++;
                
            }else{

            
            nums[i]=nums[j];
            i++;
            j++;}
        }

        return i;
    }
}