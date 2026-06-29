

import javax.management.QueryEval;

class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;int cols=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
            if(grid[i][j]=='0') continue;
            queue.add(new int[]{i,j});
            grid[i][j]='0';
            count++;
            while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
     

            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]!='0'){
                    grid[nr][nc]='0';
                    queue.add(new int[]{nr,nc});
                }
            }
        }
     
            }
        }
        return count;

    }
}