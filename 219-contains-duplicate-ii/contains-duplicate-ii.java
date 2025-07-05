class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i=0;int j=0;
        HashSet<Integer> set=new HashSet<>();

        while(j<nums.length){
            if(set.contains(nums[j])){
               if(j-i<=k){
                return true;
               }
               set.remove(nums[i]);
               i++;

            }else{
                set.add(nums[j]);
                j++;
            }
        }
        return false;
    }
}