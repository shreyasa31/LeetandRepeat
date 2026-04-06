class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> graph=new ArrayList<>();
         List<List<int[]>> revgraph=new ArrayList<>();
         long min=Long.MAX_VALUE;
         for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            revgraph.add(new ArrayList<>());
         
         }
         for(int[] k:edges){
            int u=k[0];
            int v=k[1];
            int w=k[2];

            graph.get(u).add(new int[]{v,w});
            revgraph.get(v).add(new int[]{u,w});
         }

         long[] src1dist=Dijkstra(n, graph, src1);
         long[] src2dist=Dijkstra(n, graph, src2);
         long[] destdist=Dijkstra(n, revgraph, dest);

         for(int i=0;i<n;i++){
             if (src1dist[i] == Long.MAX_VALUE ||
                src2dist[i] == Long.MAX_VALUE ||
                destdist[i] == Long.MAX_VALUE) {
                continue;
            }
             min=Math.min(min, (src1dist[i]+src2dist[i]+destdist[i]));
         }
         
         return min==Long.MAX_VALUE?-1:min;
        
    }

    long[] Dijkstra(int n, List<List<int[]>> graph, int src){
        long[] distance=new long[n];
        PriorityQueue<long[]> queue=new PriorityQueue<>((a,b)-> Long.compare(a[1],b[1]));

        Arrays.fill(distance, Long.MAX_VALUE);
        distance[src]=0;
        queue.add(new long[]{src,0});

        while(!queue.isEmpty()){
            long[] curr=queue.poll();
            int f=(int)curr[0];
            long w=curr[1];
            if(w> distance[f]) continue;
            for(int[] l:graph.get(f)){
                  int s=l[0];
                  int nw=l[1];

                  if(distance[f]!=Integer.MAX_VALUE && distance[f]+nw<distance[s]){
                    distance[s]=distance[f]+nw;
                    queue.add(new long[]{s,distance[s]});
                  }
            }
        }
        return distance;
    }
}