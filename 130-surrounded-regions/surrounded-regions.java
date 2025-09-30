import java.util.*;

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] DIRS = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        Queue<int[]> q = new LinkedList<>();

        // Step 1  enqueue all border O cells
        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                q.offer(new int[]{r, 0});
                board[r][0] = 'T'; // mark as safe temporarily
            }
            if (board[r][n - 1] == 'O') {
                q.offer(new int[]{r, n - 1});
                board[r][n - 1] = 'T';
            }
        }
        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                q.offer(new int[]{0, c});
                board[0][c] = 'T';
            }
            if (board[m - 1][c] == 'O') {
                q.offer(new int[]{m - 1, c});
                board[m - 1][c] = 'T';
            }
        }

        // Step 2  BFS to mark all O cells connected to the border as T
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O') {
                    board[nr][nc] = 'T';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 3  finalize the board
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';  // surrounded region captured
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';  // restore safe cells
                }
            }
        }
    }
}
