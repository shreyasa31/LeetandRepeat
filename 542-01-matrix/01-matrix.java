class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue=new LinkedList<>();
      int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        int rows=mat.length;
        int cols=mat[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){

                
                visited[i][j]=true;
                queue.add(new int[]{i,j,0});
                }
            }
        }
        int[][] ans=new int[rows][cols];
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];

            ans[r][c]=d;

             for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && visited[nr][nc]==false){
                         visited[nr][nc]=true;
                         queue.add(new int[]{nr,nc,d+1});
                }} 
        }
        return ans;
    }
}