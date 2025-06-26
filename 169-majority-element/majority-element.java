class Solution {
    public int majorityElement(int[] nums) {
        //for constant space use boyer moore algorithnm helpful to find out majority like more than n/k 
        int candidate1=nums[0]; int count=0;
        for(int num:nums){
           if(num==candidate1){
                count++;
           }else{
            count--;
           }


           if(count==0){
            candidate1=num;
            count=1;
           }
        }
        return candidate1;
    }
}