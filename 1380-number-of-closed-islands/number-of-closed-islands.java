class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean isClosed = true;
        int count = 0;
        // boolean[][] visited = new boolean[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] { i, j });
                    isClosed=true;
                    grid[i][j]=1;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];
                        
                    if (r == 0 || c == 0 || r == row - 1 || c == cols - 1) {
                        isClosed = false;
                    }

                        for (int[] dir : dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if (nr >= 0 && nc >= 0 && nr < row && nc < cols && grid[nr][nc]==0) {
                                grid[nr][nc] = 1;
                                queue.add(new int[] { nr, nc });
                            }
                        }
                    }

                    if (isClosed) {
                        count++;
                    }

                }
            }
        }
        return count;
    }
}