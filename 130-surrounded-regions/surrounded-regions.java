class Solution {
    public void solve(char[][] board) {
       int rows=board.length;
       int cols=board[0].length;
       int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
      // first mark all borders if its 0 with T 
       for(int i=0;i<rows;i++){
        if(board[i][0]=='O'){
            board[i][0]='T';
        }
       }

       for(int i=0;i<rows;i++){
        if(board[i][cols-1]=='O'){
            board[i][cols-1]='T';
        }
       }


        for(int j=0;j<cols;j++){
        if(board[0][j]=='O'){
            board[0][j]='T';
        }
       }

       for(int j=0;j<cols;j++){
        if(board[rows-1][j]=='O'){
            board[rows-1][j]='T';
        }
       }
Queue<int[]> queue=new LinkedList<>();
      //make connected to border T as well so do bfs from border
      for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(board[i][j]=='T'){
                queue.add(new int[]{i,j});

                while(!queue.isEmpty()){
                 int[] curr=queue.poll();

                 for(int[] k: dirs){
                    int nr=k[0]+curr[0];
                    int nc=k[1]+curr[1];

                    if(nr>=0 && nc>=0 && nr<rows && nc<cols && board[nr][nc]=='O'){
                        board[nr][nc]='T';
                        queue.add(new int[]{nr,nc});
                    }
                 }
                }
            }
        }
      }

      //chnage T to O and wherever O is there then add X
      for(int i= 0;i<rows;i++){
        for(int j=0;j<cols;j++){

            if(board[i][j]=='O'){
                board[i][j]='X';
            }else  if(board[i][j]=='T'){
                board[i][j]='O';
            }

            
        }
      }
      
      


    }
}