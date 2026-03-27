class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
          ArrayList<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int[] f:times){
            int first=f[0];
            int second=f[1];
            int third=f[2];

            list.get(first).add(new int[]{second, third});
        }

    Queue<int[]> queue=new LinkedList<>();
    int[] distance=new int[n+1];
    Arrays.fill(distance, Integer.MAX_VALUE);
    queue.add(new int[]{k,0});
    distance[k]=0;
    while(!queue.isEmpty()){
        int[] curr=queue.poll();
        int node=curr[0];
        int val=curr[1];

        for(int[] l:list.get(node)){
            int nextnode=l[0];
            int t=l[1];

            if(distance[node]+t<distance[nextnode]){
                distance[nextnode]=distance[node]+t;
                queue.add(new int[]{nextnode, distance[nextnode]});
            }
        }
    }
    int max=Integer.MIN_VALUE;
    System.out.println(Arrays.toString(distance));
    for(int i=1;i<distance.length;i++){
    if(distance[i]==Integer.MAX_VALUE) return -1;
       max=Math.max(max, distance[i]);
    }
   return max;
    }
}