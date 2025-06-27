class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        // HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
                
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}