class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color= new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        Queue<Integer> queue=new LinkedList<>();
      
        for(int i=0;i<n;i++){

        queue.add(i);
        color[0]=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            


            for(int num:graph[curr]){
                if(color[num]==-1){
                    color[num]=1-color[curr];
                    queue.add(num);
                }else if(color[num] == color[curr]){
                       return false;
                }
            }
        }}
        return true;
    }
}