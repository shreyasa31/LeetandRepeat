class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int max=0;
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int count=1;
                    queue.add(new int[]{i,j});
                    grid[i][j]=0;
                    while(!queue.isEmpty()){
                      int[] curr=queue.poll();

                      for(int[] k: dirs){
                        int nr=curr[0]+k[0];
                        int nc=curr[1]+k[1];
                        if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){
                  count++;
                  grid[nr][nc]=0;
                  queue.add(new int[]{nr,nc});
                        }
                      }
                      max=Math.max(max,count);
                    }
                }
            }
        }
        return max;
    }
}