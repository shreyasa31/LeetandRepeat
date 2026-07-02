class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,k,0});
        int[][] remainK=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
            {
                remainK[i][j]=-1;
            }
        }


        remainK[0][0]=k;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            int rk=curr[2];
            int d=curr[3];
            if(r==rows-1 && c==cols-1) return d;
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                int rem=rk;
              if (nr>=0 & nc>=0 && nr<rows && nc<cols){

              
                if(grid[nr][nc]==1)
                    rem--;}
                if(nr>=0 & nc>=0 && nr<rows && nc<cols && remainK[nr][nc]<rem){
                    remainK[nr][nc]=rem;
                    queue.add(new int[]{nr,nc,rem,d+1});
                    
                }
            }
        }
        return -1;
    }
}