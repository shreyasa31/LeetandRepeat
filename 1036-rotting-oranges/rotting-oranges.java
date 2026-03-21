class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length; int fresh=0;
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}}; int max=0;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                
                    queue.add(new int[]{i,j,0});
                }
                if(grid[i][j]==1){
                    fresh++;
                }

            }
        }
        if(fresh==0) return 0;
        while(!queue.isEmpty()){
          int[] curr=queue.poll();
          int r=curr[0];
          int c=curr[1];
          int mins=curr[2];
          max=Math.max(max,mins);
          for(int[] k: dirs){
            int nr=k[0]+r;
            int nc=k[1]+c;
         if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1){
            fresh--;
            grid[nr][nc]=2;
        
            queue.add(new int[]{nr,nc,mins+1});
         }
          }
        }
       return fresh>0?-1:max;
    }
}