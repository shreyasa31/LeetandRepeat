class Solution {
    public int numEnclaves(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<rows;i++){
            if(grid[i][0]==1){
                    grid[i][0]=2;
                    queue.add(new int[]{i,0});
                 }
                    if(grid[i][cols-1]==1){
                    grid[i][cols-1]=2;
                    queue.add(new int[]{i,cols-1});
                 }
        }
         for(int j=0;j<cols;j++){
            if(grid[0][j]==1){
                    grid[0][j]=2;
                    queue.add(new int[]{0,j});
                 }
                    if(grid[rows-1][j]==1){
                    grid[rows-1][j]=2;
                    queue.add(new int[]{rows-1,j});
                 }
        }

        while(!queue.isEmpty()){
            int[] curr=queue.poll();

            int r=curr[0];
            int c=curr[1];

            for(int[] k:dirs){
                int nr=k[0]+r;
                int nc=k[1]+c;

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        int count=0;
       for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                  count++;
                }
                else if(grid[i][j]==2){
                    grid[i][j]=1;
                }
            }}
return count;
    }
}