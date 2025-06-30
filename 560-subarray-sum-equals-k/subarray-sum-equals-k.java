class Solution {
    public int subarraySum(int[] nums, int k) {
          HashMap<Integer,Integer> map=new HashMap<>();
          map.put(0,1); // 1 2 3 check 1 2 here no removal needed so 0,1 added already otehrwise count will be 0 than 1 
         int count=0; int sum=0;
          for(int i=0;i<nums.length;i++){
               sum=sum+nums[i];
               if(map.containsKey(sum-k)){
                  count+=map.get(sum-k);
               }
                map.put(sum, map.getOrDefault(sum,0)+1);
               
          }
          return count;
    }
}