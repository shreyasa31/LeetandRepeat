class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        if(source==target) return 0;
        for(int i=0;i<routes.length;i++){
            for(int j:routes[i]){
               if(!map.containsKey(j)){
                    map.put(j, new ArrayList<>());;
               }
               map.get(j).add(i);
            }
        }
        if(!map.containsKey(source)) return -1;
        Queue<int[]> queue=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int k:map.get(source)){
            queue.add(new int[]{k,1});
            set.add(k);
        }

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int n=curr[0];
            int d=curr[1];
         
            for(int a:routes[n]){
                if(a==target) return d;
                for(int k:map.get(a)){
                    if(!set.contains(k)){
                        queue.add(new int[]{k, d+1});
                        set.add(k);
                    }
                }
            }
        }
        return -1;
    }
}