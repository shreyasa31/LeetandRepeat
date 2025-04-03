

import javax.swing.border.Border;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row=new HashSet[board.length];
        HashSet<Character>[] col=new HashSet[board.length];
        HashSet<Character>[] box=new HashSet[board.length];

        for(int i=0;i<board.length;i++){
            row[i]=new HashSet<Character>();
            col[i]=new HashSet<Character>();
            box[i]=new HashSet<Character>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }

                if(row[i].contains(board[i][j])){
                    return false;
                }
                row[i].add(board[i][j]);

                 if(col[j].contains(board[i][j])){
                    return false;
                }
                col[j].add(board[i][j]);

                int idx= (i/3)*3 + (j/3);

                 if(box[idx].contains(board[i][j])){
                    return false;
                }
                box[idx].add(board[i][j]);
            }
        }
        return true;
    }
}