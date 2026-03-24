class Solution {
    public boolean validTree(int n, int[][] edges) {
        // its a tree if edges==n-1(no cycle) and all are connectedq 
        if(edges.length!=n-1) return false;
        ArrayList<List<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] k: edges){
          int first=k[0];
          int second=k[1];
          list.get(first).add(second);
          list.get(second).add(first);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            for(int k:list.get(curr)){
                if(visited[k]==false){
                    visited[k]=true;
                    queue.add(k);
                }
            }
        }
        for(int i=0;i<visited.length;i++)
        {
            if(visited[i]==false){
                return false;
            }
        }
        return true;
    }
}