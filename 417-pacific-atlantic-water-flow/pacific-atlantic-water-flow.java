class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<int[]> pacificqueue = new LinkedList<>();
        Queue<int[]> atlanticqueue = new LinkedList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        for (int i = 0; i < rows; i++) {
             pacificqueue.add(new int []{i,0});
             atlanticqueue.add(new int[]{i,cols-1});
        }

        for (int j = 0; j < cols; j++) {
             pacificqueue.add(new int[]{0,j});
             atlanticqueue.add(new int[]{rows-1,j});
        }
        boolean[][] pacific=bfs(pacificqueue, heights);
        boolean[][] atlantic=bfs(atlanticqueue, heights);
      
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> r=new ArrayList<>();
                    r.add(i);
                    r.add(j); // list.of(i,j)
                    list.add(r);
                }
            }
        }


        return list;
        
        

    }
    boolean[][] bfs(Queue<int[]> queue, int[][] heights){
        boolean[][] visited=new boolean[heights.length][heights[0].length];
        boolean[][] reachable=new boolean[heights.length][heights[0].length];
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            
            int r=curr[0];
            int c=curr[1];
            visited[r][c]=true;
            reachable[r][c]=true;
            
            for(int[] k:dirs){
                int nr=k[0]+r;
                int nc=k[1]+c;

                if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && visited[nr][nc]==false && heights[r][c]<=heights[nr][nc]){
                    visited[nr][nc]=true;
                    queue.add(new int[]{nr,nc});
                }
            }
                    
        }
        return reachable;
    }


}