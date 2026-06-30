class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edges ){
            int f1=edge[0];
            int f2=edge[1];
  
            adjList.get(f1).add(f2);
            adjList.get(f2).add(f1);

        }
      boolean visited[]=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        visited[source]=true;
        while (!queue.isEmpty()) {
            int curr=queue.poll();
            if(curr==destination) return true;
            for(int i:adjList.get(curr)){
                if(visited[i]==false){
                    visited[i]=true;
                     queue.add(i);
                
            }}

        }
        return false;
    }
}