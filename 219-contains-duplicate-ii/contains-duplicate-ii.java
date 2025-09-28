class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int i=0;int j=0; boolean flag=false;
        while(j<nums.length){
            if(!map.containsKey(nums[j])){
                 map.put(nums[j],j);
                 j++;
            }else{
                if(Math.abs(map.get(nums[j])-j)<=k){
                    flag=true;
                }
                map.put(nums[j],j);
               
                i++;
                j++;
            }
        }
        return flag;
    }
}