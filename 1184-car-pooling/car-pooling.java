class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num[]:trips){
            int numPassengers=num[0];
            int from=num[1];
            int to=num[2];


            map.put(from, map.getOrDefault(from,0)+numPassengers);
            
            map.put(to, map.getOrDefault(to,0)-numPassengers);
        }
           int currPassenger=0 ;
        for(int n:map.values()){
         
            currPassenger+=n;
            if(currPassenger>capacity){
                return false;
            }
            
        }
        return true;
    }
}