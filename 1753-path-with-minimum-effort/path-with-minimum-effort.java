class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
         PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[0]-b[0]);
         queue.add(new int[]{0,0,0});
         int[][] dist=new int[rows][cols];
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[0].length;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
         while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int d=curr[0];
            int r=curr[1];
            int c=curr[2];

            if(d> dist[r][c]){
                continue;
            }
             if (r == rows - 1 && c == cols - 1) {
        return d;
    }

            for(int[] k:dir){
                int nr=k[0]+r;
                int nc=k[1]+c;

                if(nr>=0 && nc>=0 && nr<rows && nc<cols){
                    int diff=Math.abs(heights[r][c]-heights[nr][nc]);
                    int neweffort=Math.max(d,diff);

                    if(neweffort<dist[nr][nc]){
                        dist[nr][nc]=neweffort;
                        queue.add(new int[]{neweffort, nr, nc});
                    }
                }
            }
         }
return 0;
    }
}