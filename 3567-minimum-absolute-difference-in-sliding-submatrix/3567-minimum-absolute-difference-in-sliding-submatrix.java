class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {

        int m = grid.length, n = grid[0].length ;

        int[][] ans = new int[m - k + 1][n - k + 1] ;

        for(int i = 0; i < m - k + 1; ++i) {
            for(int j = 0; j < n - k + 1; ++j) {

                List<Integer> arr = new ArrayList<>() ;

                for(int x = i; x < i + k; ++x) {
                    for(int y = j; y < j + k; ++y) {
                        arr.add(grid[x][y]) ;
                    }
                }

                Collections.sort(arr) ;

                int minDiff = Integer.MAX_VALUE ;

                for(int idx = 0; idx < arr.size() - 1; ++idx) {
                    if(arr.get(idx + 1).equals(arr.get(idx))) {
                        continue ;
                    }
                    minDiff = Math.min(minDiff, arr.get(idx + 1) - arr.get(idx)) ;
                }

                ans[i][j] = minDiff != Integer.MAX_VALUE ? minDiff : 0 ;

            }
        }

        return ans ;

    }
}