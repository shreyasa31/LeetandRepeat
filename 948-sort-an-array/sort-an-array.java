class Solution {
    public int[] sortArray(int[] nums) {
          if (nums == null || nums.length <= 1) {
            return nums; // No sorting needed for null or single-element arrays
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;


        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }


        int[] temp=new int[max-min+1];
        for(int num:nums){
            temp[num-min]++;
        }

        int j=0;
        int i=0;
        while(i<temp.length){
            if(temp[i]==0){
                i++;
            }else{
                nums[j]=i+min;
                j++;
                temp[i]--;
            }
        }
        return nums;
    }
}