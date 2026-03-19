class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                bfs(i,isConnected, visited);
            }
        }

        return count;

    }

    void bfs(int i, int[][] isConnected, boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        visited[i]=true;
        while(!queue.isEmpty()){
            int curr=queue.poll();

            for(int j=0;j<isConnected.length;j++){
                if(isConnected[curr][j]==1 && visited[j]==false)
                {
                    visited[j]=true;
                    queue.add(j);
                }
            }
        }
    }
}