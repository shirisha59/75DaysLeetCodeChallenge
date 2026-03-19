class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpX = new int[m][n];
        int[][] dpY = new int[m][n];

        dpX[0][0] = grid[0][0] == 'X' ? 1 : 0;
        dpY[0][0] = grid[0][0] == 'Y' ? 1 : 0;

        for (int j = 1; j < n; j++) {
            dpX[0][j] = (grid[0][j] == 'X' ? 1 : 0) + dpX[0][j - 1];
            dpY[0][j] = (grid[0][j] == 'Y' ? 1 : 0) + dpY[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            dpX[i][0] = (grid[i][0] == 'X' ? 1 : 0) + dpX[i - 1][0];
            dpY[i][0] = (grid[i][0] == 'Y' ? 1 : 0) + dpY[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpX[i][j] = (grid[i][j] == 'X' ? 1 : 0) + dpX[i][j - 1] + dpX[i - 1][j] - dpX[i - 1][j - 1];
                dpY[i][j] = (grid[i][j] == 'Y' ? 1 : 0) + dpY[i][j - 1] + dpY[i - 1][j] - dpY[i - 1][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dpX[i][j] == dpY[i][j] && dpX[i][j] > 0) result++;
            }
        }
        return result;
    }
}