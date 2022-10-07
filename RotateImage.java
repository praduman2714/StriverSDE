class Solution {
    // This is the brute force way to do this question 
    // Space complextity = o(n^2);
    // Time Complextity = o(n^2);
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                res[j][n-1-i] = matrix[i][j];
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                matrix[i][j] = res[i][j];
            }
        }
    }
}


Space Optimize approach
class Solution {
    public void rotate(int[][] matrix) {
        // first we transpose the matrix
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // After transposing we just reverse the row of the matrix.
        
        for(int i = 0; i<n; i++){
            int l = 0, r = n-1;
            while(l <= r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++; r--;
            }
        }
    }
}
// Most Optimal
// Check leetcode for more clariflication 
class Solution {
    public void rotate(int[][] matrix) {
        // Time complexity o(1);
        // The idea behind the code is that, when you dry run the code 
        // You'll see that all the four element will replace each other.
        int n = matrix.length;
        for(int i = 0; i < (n + 1) / 2; i ++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}