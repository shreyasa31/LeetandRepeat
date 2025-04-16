class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0;
        int down = rows - 1;
        int left = 0;
        int right = cols - 1;

        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        while (res.size()<rows*cols) {
            // traverse from left6 to right
            for (int col = left; col <= right; col++) {
                res.add(matrix[left][col]);
            }

            up++;

            // traverse from top to bottom

            for (int row = up; row<= down; row++) {
                res.add(matrix[row][right]);
            }

            right--;

            // traverse from right to left

            if (up <= down) {
                for (int col = right; col >= left; col--) {
                    res.add(matrix[down][col]);
                }
                down--;
            }

            if (left <= right) {
                for (int row = down; row >= up; row--) {
                    res.add(matrix[row][left]);
                }
                left++;
            }

        }
        return res;
    }
}