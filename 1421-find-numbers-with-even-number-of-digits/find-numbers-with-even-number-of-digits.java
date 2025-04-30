class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num:nums){
            String num1=String.valueOf(num);
            if(num1.length()%2==0){
               count++;
            }
        }
        return count;  // if not this then do math num/=10
    }
}