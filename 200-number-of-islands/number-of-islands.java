class Solution {
    public int numIslands(char[][] grid) {
        int[][] dir = new int[][] {
                { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }
        };
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    queue.offer(new int[] { i, j });
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {

                        int[] k = queue.poll();
                        
                        for (int[] d : dir) {
int nr = k[0] + d[0];
                        int nc = k[1] + d[1];
                            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.offer(new int[] { nr, nc });
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
