class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        if(grid[0][0]==1) return -1;
        if(grid[rows-1][cols-1]==1) return -1;
        int[][] dir={{1,0},{-1,0},{0,-1},{0,1},{1,-1},{1,1},{-1,-1},{-1,1}};
        int p=0;
        boolean[][] visited=new boolean[rows][cols];
            queue.add(new int[]{0,0,1});
                visited[0][0]=true;
                
                while(!queue.isEmpty()){
                    int [] curr=queue.poll();
                    int r=curr[0];
                    int c=curr[1];
                    int d=curr[2];
                    if(r==rows-1 &&  c==cols-1){
                    return  d;
                }
                    for(int[] k:dir){
                        int nr=k[0]+r;
                        int nc=k[1]+c;

                        if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==0 && visited[nr][nc]==false)
                        {
                            visited[nr][nc]=true;
                            queue.add(new int[]{nr,nc,d+1});

                        }
                    }
            
        }
        return -1;
    }
}