class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        queue.add(new int[]{0,0,k});

        int[][] kdistance=new int[rows][cols];
        for(int i=0;i<kdistance.length;i++){
            for(int j=0;j<kdistance[0].length;j++){
                kdistance[i][j]=-1;
            }
        }
        kdistance[0][0]=k;
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];
                int kd=curr[2];

                if(r==rows-1 && c==cols-1){
                    return level;
                }

                for(int[] l:dirs){
              int nr=l[0]+r;
              int nc=l[1]+c;

              int rem=kd;

              if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1){
                rem--;
              }


              
              if(nr>=0 && nc>=0 && nr<rows && nc<cols && kdistance[nr][nc]<rem){
                   kdistance[nr][nc]=rem;
                   queue.add(new int[]{nr,nc,rem});
                  }
                }
            }
            level++;
        }

      return -1;
    }
}