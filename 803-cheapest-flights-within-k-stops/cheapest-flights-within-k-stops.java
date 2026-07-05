class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int distance[]=new int[n];

        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[src]=0;
    List<List<int[]>> adjList=new ArrayList<>();
    for(int i=0;i<n;i++){
        adjList.add(new ArrayList<>());
    }
    for(int[] f:flights){
        int n1=f[0];
        int n2=f[1];
        int w=f[2];

        adjList.get(n1).add(new int[]{n2,w});
    }
    Queue<int[]> queue=new LinkedList<>();
    queue.add(new int[]{src,0});
    int level=0;

    while(level<=k && !queue.isEmpty()){
        int size=queue.size();

        for(int i=0;i<size;i++){
            int[] curr=queue.poll();
            int node=curr[0];
            int d=curr[1];
        
            for(int[] a: adjList.get(node)){
                int n1=a[0];
                int w1=a[1];

                if(distance[node]!=Integer.MAX_VALUE && d+w1<distance[n1]){
                      distance[n1]=d+w1;
                      System.out.print(distance[n1]);
                      queue.add(new int[]{n1, distance[n1]});
                }
            }
        }
        level++;
    }
    System.out.println(Arrays.toString(distance));
    return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
    }
}