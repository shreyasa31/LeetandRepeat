class Solution {
    public int countPaths(int n, int[][] roads) {
        long mod=1000000007;
        ArrayList<List<long[]>> list=new ArrayList<>(); //time canbe greater 10 power 9 so can overflow

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        
        }

        for(int[] r: roads){
            int first=r[0];
            int second=r[1];
            int time=r[2];

            list.get(first).add(new long[]{second, time});
            list.get(second).add(new long[]{first, time});
        }

        PriorityQueue<long[]> queue=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1])); //overflow might happen simce lare number sso cant a[0]-b[0]
        long[] distance=new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0]=0;
        long[] ways=new long[n];

        queue.add(new long[]{0,0});
        ways[0]=1;

        while(!queue.isEmpty()){
            long[] curr=queue.poll();
            int node=(int)curr[0]; //since nodes are int
            long t=curr[1];

            if(t> distance[node]) continue;

            for(long[] k: list.get(node)){
                 int f= (int)k[0];
                 long s=k[1];

                 long newdist=distance[node]+s;

                 if( newdist< distance[f]){
                    distance[f]=newdist;
                    queue.add(new long[]{f, distance[f]});
                    ways[f]=ways[node];
                 }else if(newdist == distance[f]){
                  ways[f]=(ways[node]+ways[f])%mod;
                 }
            }
        }

        return (int)(ways[n-1] % mod);
    }
}