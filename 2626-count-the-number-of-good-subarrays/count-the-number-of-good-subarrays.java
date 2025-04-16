class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        long pairs=0;
        long result=0; int j=0;
        for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i]))
        {
            pairs+=map.get(nums[i]);
        }
          
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        while(pairs>=k){
            result+=nums.length-i;
            if(map.get(nums[j])>=2){
               pairs=pairs-(map.get(nums[j])-1);
            }
           map.put(nums[j], map.get(nums[j])-1);
           j++;

        }
        }

        return result;
    }
}