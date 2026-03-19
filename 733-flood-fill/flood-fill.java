class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue=new LinkedList<>();
        int oldcolor=image[sr][sc];
        if(color==oldcolor) return image;
        int cols=image[0].length;
        int rows=image.length;
        image[sr][sc]=color;
        queue.add(new int[]{sr,sc});
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
          int[] curr=queue.poll();
          int r= curr[0];
          int c=curr[1];

          for(int[] dir:dirs){
            int nr=r+dir[0];
            int nc=c+dir[1];


            if(nr>=0 && nc>=0 && nr<rows && nc<cols && image[nr][nc]==oldcolor){
                   image[nr][nc]=color;
                   queue.add(new int[]{nr,nc});
            }
          }
        }
        return image;
    }
}