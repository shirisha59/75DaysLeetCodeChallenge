class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;        // number of rows
        int n = mat[0].length;     // number of columns
        
        int shift = k % n;         // effective shift (extra shifts repeat)

        // Traverse each row
        for (int i = 0; i < m; i++) {
            
            // Traverse each column
            for (int j = 0; j < n; j++) {
                
                int newIndex;
                
                if (i % 2 == 0) {
                    // Even row → left shift
                    // Element at j moves to (j - shift)
                    // Instead of moving elements, we check where current should come from
                    newIndex = (j + shift) % n;
                } else {
                    // Odd row → right shift
                    // Element at j moves to (j + shift)
                    // Reverse mapping to compare
                    newIndex = (j - shift + n) % n;
                }

                // If any element doesn't match after shifting → return false
                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }

        // If all elements match → matrix is same after k operations
        return true;
    }
}