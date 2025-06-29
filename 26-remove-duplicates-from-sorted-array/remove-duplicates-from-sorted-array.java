class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }
        
        int j=0;
        for(int i:set){
            nums[j]=i;
            j++;
        }
        return j-0;
    }
}