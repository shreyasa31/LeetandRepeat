class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        Queue<int[]> pacificQueue=new LinkedList<>();
        Queue<int[]> atlanticQueue=new LinkedList<>();

        boolean[][] pacificVisited=new boolean[rows][cols];
        boolean[][] atlanticVisited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
           pacificQueue.add(new int[]{i, 0});
           pacificVisited[i][0]=true;
           atlanticQueue.add(new int[]{i, cols-1});
            atlanticVisited[i][cols-1]=true;
             
        }

        for(int j=0;j<cols;j++){
           pacificQueue.add(new int[]{0, j});
            pacificVisited[0][j]=true;
           atlanticQueue.add(new int[]{rows-1, j});
           atlanticVisited[rows-1][j]=true;
             
        }


        boolean[][] pacific=bfs(heights, pacificQueue, pacificVisited);
        boolean[][] atlantic=bfs(heights, atlanticQueue,atlanticVisited );
        List<List<Integer>> res=new ArrayList<>();
       
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> l = new ArrayList<>();
    l.add(i);
    l.add(j);
    res.add(l);
                }
        
               
            }
        }
        return res;
    }

    boolean[][] bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited){
        int row=heights.length;
        int col=heights[0].length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
         
        boolean[][] res=new boolean[row][col];
        while(!queue.isEmpty()){

            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            res[r][c]=true;
            for(int[] dir:dirs ){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nc>=0 && nr<row && nc<col && visited[nr][nc]==false && heights[nr][nc]>=heights[r][c]){
                   visited[nr][nc]=true;
                   queue.add(new int[]{nr,nc});
                }
            }

        }
        
return res;
  
    }
}