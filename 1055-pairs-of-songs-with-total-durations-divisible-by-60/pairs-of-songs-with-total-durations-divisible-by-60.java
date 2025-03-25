class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int c:time){
            int rem=c%60;
            int comp=(60-rem)%60;
            
            if(map.containsKey(comp)){
                count+=map.get(comp);
            }
            map.put(rem,map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}