class Solution {
    public void solve(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;
  int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int j=0;j<cols;j++){
        
             if(board[0][j]=='O'){
                 board[0][j]='T';
             }

             if(board[rows-1][j]=='O'){
                board[rows-1][j]='T';
             }
        }


        for(int i=0;i<rows;i++){
        
             if(board[i][0]=='O'){
                 board[i][0]='T';
             }

             if(board[i][cols-1]=='O'){
                board[i][cols-1]='T';
             }
        }


        Queue<int[]> queue=new LinkedList<>();
       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(board[i][j]=='T'){
                queue.add(new int[]{i,j});
                
                
                while(!queue.isEmpty()){
                    int[] curr=queue.poll();
                    int r=curr[0];
                    int c=curr[1];

                    for(int[] dir:dirs){
                        int nr=r+dir[0];
                        int nc=c+dir[1];

                        if(nr>=0 && nc>=0 && nr<rows && nc<cols && board[nr][nc]=='O'){
                        board[nr][nc]='T';
                        queue.add(new int[]{nr,nc});
                        }
                    }



                }
                           
             }
        }
       }


       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(board[i][j]=='T'){
                board[i][j]='O';
            }else if(board[i][j]=='O'){
               board[i][j]='X';
            }
        }
       }

    }
}