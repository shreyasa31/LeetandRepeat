import java.util.*;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] DIRS = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int best = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = 0;
                    q.offer(new int[]{r, c});
                    grid[r][c] = 0;

                    while (!q.isEmpty()) {
                        int[] cell = q.poll();
                        int cr = cell[0], cc = cell[1];
                        area++;

                        for (int[] d : DIRS) {
                            int nr = cr + d[0];
                            int nc = cc + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                                grid[nr][nc] = 0;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    best = Math.max(best, area);
                }
            }
        }
        return best;
    }
}
