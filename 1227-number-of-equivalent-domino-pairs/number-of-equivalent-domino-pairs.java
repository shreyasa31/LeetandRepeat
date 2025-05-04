class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map=new HashMap<>();
        int count=0; int res=0;
        for(int[] nums:dominoes){
            int first=nums[0];
            int second=nums[1];

            String key= first<second? first+","+second: second +","+first;
            
           if(map.containsKey(key)){
            count+=map.get(key);
           }
            map.put(key, map.getOrDefault(key,0)+1);
            
        }
        
        return count;
    }
}