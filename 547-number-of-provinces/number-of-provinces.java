class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==false){
                 count++;
                 bfs(isConnected, i, visited);
            }
        }
        return count;
    }

    void bfs(int[][] Connected, int i, boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);

        visited[i]=true;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int j=0;j<Connected.length;j++){
                if(Connected[curr][j]==1 && visited[j]==false){
                    visited[j]=true;
                    queue.add(j);
                }
            }
        }
        
    }
}