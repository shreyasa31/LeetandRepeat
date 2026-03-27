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

    PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[1]-b[1]);

    queue.add(new int[] {src,0,0});
    int[][] dist=new int[n][k+2];
    for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
    dist[src][0]=0;

    while(!queue.isEmpty())
{
    int[] curr=queue.poll();
    int node=curr[0];
    int c=curr[1];
    int stops=curr[2];
    
    if(node==dst) return c;
    if(stops>=k+1) continue;
    if(c> dist[node][stops]) continue;

    for(int[] l: list.get(node)){
        int nextnode=l[0];
        int cost=l[1];
        int newflights=stops+1;
        if(dist[node][stops]!=Integer.MAX_VALUE && dist[node][stops]+cost<dist[nextnode][newflights]){
            dist[nextnode][newflights]=dist[node][stops]+cost;
            queue.add(new int[]{nextnode, dist[nextnode][newflights],newflights });
        }
    }

}    
return -1;
}
}