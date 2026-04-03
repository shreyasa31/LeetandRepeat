class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] visited=new boolean[n];
        int[] dist=new int[n];
        int mincost=0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        for(int i=0;i<n;i++){
           int u=-1;

           for(int j=0;j<n;j++){
            if(visited[j]==false && (u==-1 || dist[j]<dist[u])){
                u=j;
            }
           }
         
           visited[u]=true;
           mincost+=dist[u];

           for(int v=0;v<n;v++){

            int cost=Math.abs(points[u][0]-points[v][0])+ Math.abs(points[u][1]-points[v][1]);

            dist[v]=Math.min(dist[v], cost);
           }

        }
       return mincost;
    }
}