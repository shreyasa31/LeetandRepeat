class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        if(grid[0][0]==1 || grid[rows-1][cols-1]==1) return -1;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,1});
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,-1},{-1,1}};
        grid[0][0]=1;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];

            if(r==rows-1 && c==cols-1) return d;

            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    queue.add(new int[]{nr,nc,d+1});
                }
            }
        }
        return -1;
    }
}