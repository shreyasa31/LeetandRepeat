class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            
            list.add(new ArrayList<>());
        }
        for(int[] i:edges){
           
            int f=i[0];
            int s=i[1];

           list.get(f).add(s); 
           list.get(s).add(f);
        }
        boolean[] visited=new boolean[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
              
                bfs(i,list, visited);
                  count++;
            }
        }

        return count;

    }

    void bfs(int i, ArrayList<ArrayList<Integer>> edges, boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        visited[i]=true;
        while(!queue.isEmpty()){
            int curr=queue.poll();
           
            for(int j: edges.get(curr)){
                if(visited[j]==false)
                {
                    visited[j]=true;
                    queue.add(j);
                }
            }
        }
    }
    
}