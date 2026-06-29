class Solution {
    public int countBattleships(char[][] board) {
        Queue<int[]> queue=new LinkedList<>();
       int rows=board.length;
       int cols=board[0].length;
        int count=0;
  int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='X'){
                    queue.add(new int[]{i,j});
                    board[i][j]='.';
                    count++;
                    while(!queue.isEmpty())
                    {
                        int[] curr=queue.poll();
                        int r=curr[0];
                        int c=curr[1];

                        for(int[] dir : dirs){
                           int nr=r+dir[0];
                           int nc=c+dir[1];

                           if(nr>=0 && nc>=0 && nr<rows && nc<cols && board[nr][nc]=='X'){
                                board[nr][nc]='.';
                                queue.add(new int[]{nr,nc});
                           }
                        }
                    }
                }
            }
        }
        return count;
    }
}