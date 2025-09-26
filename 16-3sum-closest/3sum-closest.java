class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
               if(Math.abs(target-sum)<Math.abs(diff) )
                {
                    diff=target-sum;
                }
                if(sum<target){
                    j++;
                }else if(sum>target){
                    k--;
                }else{
                    return target; //exact match is a correct match
                }
            }
        }
        return target-diff;
    }
}