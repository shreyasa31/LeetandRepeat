class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int[] e:edges){
            map.put(e[0], map.getOrDefault(e[0], 0)+1);
            map.put(e[1], map.getOrDefault(e[1], 0)+1);
        }

        for(int degree: map.keySet()){
            if(map.get(degree)==edges.length){
                return degree;
            }
        }
        return -1;
    }
}