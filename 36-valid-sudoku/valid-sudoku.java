class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rows=[haset1:row1, hashset2:row2 ......]
        //so hashset datatype

        HashSet<Character>[] rows=new HashSet[board.length];
        HashSet<Character>[] cols=new HashSet[board.length];
        HashSet<Character>[] box=new HashSet[board.length];

        for(int i=0;i<board.length;i++)
        {
            rows[i]=new HashSet<Character>();
            cols[i]=new HashSet<Character>();
            box[i]=new HashSet<Character>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }

                if(rows[i].contains(board[i][j])){
                     return false;
                }
                rows[i].add(board[i][j]);

                if(cols[j].contains(board[i][j])){
                     return false;
                }
                cols[j].add(board[i][j]);

                int idx=(i/3)*3+(j/3);
                if(box[idx].contains(board[i][j])){
                    return false;
                }
                box[idx].add(board[i][j]);
            }
        }
        return true;
    }
}