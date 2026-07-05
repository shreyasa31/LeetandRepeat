class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        int max=Integer.MIN_VALUE;
        for(int i:set){
            if(!set.contains(i-1)){

            
            int j=i;
            int count=0;
            
            while(set.contains(j)){
                j++;
                count++;
            }
            max=Math.max(max, count);
        }}
        return max==Integer.MIN_VALUE?0:max;
    }
}