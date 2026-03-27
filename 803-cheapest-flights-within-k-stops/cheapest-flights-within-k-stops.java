class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] f:flights){
            int first=f[0];
            int second=f[1];
            int third=f[2];

            list.get(first).add(new int[]{second, third});
        }

    Queue<int[]> queue=new LinkedList<>();
    int[] distance=new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    queue.add(new int[]{src,0});
    distance[src]=0;
    int level=0;
    while(level<=k && !queue.isEmpty()){
        int size=queue.size();
        for(int i=0;i<size;i++){
            int[] curr=queue.poll();
            int node=curr[0];
            int l=curr[1];

            for(int[] m: list.get(node)){
                int nextnode=m[0];
                int cost=m[1];

                if(l+cost<distance[nextnode]){
                    distance[nextnode]=l+cost;
                    queue.add(new int[]{nextnode, distance[nextnode]});
                }
            }
        }
        level++;
    }
    return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
}
}