class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int n = set.size();

        int count = 0;
        HashMap<Integer, Integer> result=new HashMap<>();
        int i = 0;
        int j = i;
        while (j < nums.length) {
            result.put(nums[j], result.getOrDefault(nums[j],0)+1);

            while (n == result.size()) {
                count += (nums.length) - (j);

                result.put(nums[i], result.get(nums[i])-1);
                if(result.get(nums[i])==0){
                    result.remove(nums[i]);
                }
                i++;
            }
               j++;
            
           

        }
        return count;
    }
}