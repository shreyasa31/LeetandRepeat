class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int max=0;
        for(int n: map.values()){
          max=Math.max(max,n);

        }
        int count=0;
        for(int n: map.values()){
          if(n==max)
          {
           count+=n;
          }
          
        }
        return count;
    }
}