import java.util.*;                                   // import utilities for Queue and List

class Solution {                                      // class wrapper required by LeetCode
    public int orangesRotting(int[][] grid) {         // function that returns the minimum minutes or minus one
        int m = grid.length;                           // number of rows
        int n = grid[0].length;                        // number of columns

        int[][] DIRS = new int[][]{                    // four direction vectors row col
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}          // down up right left
        };                                             // end of direction array

        Queue<int[]> q = new LinkedList<>();           // normal queue for BFS each item holds row col time
        int fresh = 0;                                 // count of fresh oranges

        for (int r = 0; r < m; r++) {                  // iterate rows
            for (int c = 0; c < n; c++) {              // iterate columns
                if (grid[r][c] == 2) {                 // found a rotten orange
                    q.offer(new int[]{r, c, 0});       // enqueue as a starting source with time zero
                } else if (grid[r][c] == 1) {          // found a fresh orange
                    fresh++;                            // increment fresh count
                }                                       // end if fresh
            }                                           // end columns loop
        }                                               // end rows loop

        if (fresh == 0) return 0;                      // no fresh oranges at start so zero minutes

        int minutes = 0;                                // track the last time a rot event happened

        while (!q.isEmpty()) {                          // standard BFS loop
            int[] cur = q.poll();                       // pop current cell and time
            int r = cur[0];                             // current row
            int c = cur[1];                             // current column
            int t = cur[2];                             // time when this cell became rotten
            minutes = Math.max(minutes, t);             // keep the maximum time seen so far

            for (int[] d : DIRS) {                      // try four neighbors
                int nr = r + d[0];                      // neighbor row
                int nc = c + d[1];                      // neighbor column

                if (nr >= 0 && nr < m                   // row inside grid
                        && nc >= 0 && nc < n            // column inside grid
                        && grid[nr][nc] == 1) {         // neighbor is fresh
                    grid[nr][nc] = 2;                   // turn neighbor to rotten
                    fresh--;                            // one less fresh orange remains
                    q.offer(new int[]{nr, nc, t + 1});  // enqueue neighbor with time plus one minute
                }                                       // end neighbor check
            }                                           // end directions loop
        }                                               // end BFS

        return fresh == 0 ? minutes : -1;               // if all fresh are rotted return minutes else minus one
    }                                                   // end function
}                                                       // end class
