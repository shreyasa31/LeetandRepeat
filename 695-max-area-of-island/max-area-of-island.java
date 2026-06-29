class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int max=Integer.MIN_VALUE; 
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0) continue;
                queue.add(new int[]{i,j});
                grid[i][j]=0;
                int count=0;
                while(!queue.isEmpty()){
                    count++;
                    int[] curr=queue.poll();
                    int r=curr[0];
                    int c=curr[1];

                    for(int[] dir: dirs){
                        int nr=dir[0]+r;
                        int nc=dir[1]+c;

                        if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1){
                            grid[nr][nc]=0;
                            queue.add(new int[]{nr,nc});
                        }
                    }
                }
       
                System.out.println(count);
                max=Math.max(max,count);
            }
        }
        return max==Integer.MIN_VALUE?max=0: max;
    }
}