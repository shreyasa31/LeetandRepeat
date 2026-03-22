class Solution {
    public int closedIsland(int[][] grid) { // any part of island shudnt touch the boundry
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int count = 0;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        int cols = grid[0].length; boolean isclosed=false;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0  && visited[i][j]==false) {
                    queue.add(new int[] { i, j });
                    isclosed=true;
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];
                        if(r==0 || c==0 || r==rows-1|| c==cols-1){
                                 isclosed=false;
                            
                            }
                            
                        for (int[] k : dirs) {
                            int nr = k[0] + r;
                            int nc = k[1] + c;
                            
                            if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==0){
                                if(visited[nr][nc]==false){
                                    visited[nr][nc]=true;
                                    queue.add(new int[]{nr,nc});
                                }
                            }

                        }
                    }
   if(isclosed) count++;
                }
             
            }
        }
                          
    
        return count;
    }
}