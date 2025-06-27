class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        HashSet<Integer> set=new HashSet<>();
      
        for(int num1:nums){
            set.add(num1);
        }
        int max=0;
        for(int num:set){
          
            if(!set.contains(num-1)){
            int k=num;
            int count=0;
            while(set.contains(k+1)){
                count++;
                k++;
            }
            max=Math.max(max,count+1);
            }
        }
        
        return max;
    }
}