class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor=image[sr][sc];
        if(oldColor==color) return image;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{sr,sc});
        image[sr][sc]=color;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];


            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nc>=0 && nr<image.length && nc<image[0].length && image[nr][nc]==oldColor)

                {
                    image[nr][nc]=color;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}