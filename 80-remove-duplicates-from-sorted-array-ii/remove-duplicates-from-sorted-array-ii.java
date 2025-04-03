class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0; int count=1;
    for(int i=0;i<nums.length;i++){
           if(i<nums.length-1 && nums[i]==nums[i+1]){
             count++;
           }else{
            count=1;
           }

           if(count<=2){
            nums[j]=nums[i];
            j++;
           }
           
        }
        return j;
    }
}