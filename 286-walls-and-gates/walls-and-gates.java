class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows=rooms.length;
        int cols=rooms[0].length;
        Queue<int[]> queue=new LinkedList<>();
   int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rooms[i][j]==0){
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];

             for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && rooms[nr][nc]==2147483647){
                    int newD=d+1;
                      rooms[nr][nc]=newD;
                      queue.add(new int[]{nr,nc,newD});
                }
             }


        }
       
    }
}