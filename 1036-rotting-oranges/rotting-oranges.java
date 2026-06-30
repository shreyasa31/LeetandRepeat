class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length; int fresh=0; int max=0;
           int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j,0});
                }
                if(grid[i][j]==1)
                fresh++;

            }
        }
        
        while(!queue.isEmpty()){
            int[] curr=queue.poll();

            int r=curr[0];
            int c=curr[1];
             int t=curr[2];
            max=Math.max(t,max);
            for(int[] dir: dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1){
                    grid[nr][nc]='2';
                    queue.add(new int[]{nr, nc,t+1});
                    fresh--;
                }
            }


        }
        return fresh>0?-1:max;
    }
}