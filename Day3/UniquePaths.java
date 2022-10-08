class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] val : dp) Arrays.fill(val, -1);
        return f(m-1, n-1, dp);
    }
    
    public int f(int i, int j, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(i == 0 || j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = f(i-1, j, dp) + f(i, j-1, dp);
    }
}

Time Complexity = O(n*m)
Space Complexity = O(n*m) + stack space

Using Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<n ; i++){
            dp[0][i] = 1;
        }
        for(int i = 0; i<m;i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}

Time Complexity : O(n*m)
Space Complexity : O(n*m)

Optimal Solution
class Solution {
    public int uniquePaths(int m, int n) {
        // In future if you don't get this solutions then refer take you forward Striver SDE
        int N = m + n -2;
        int r = m - 1;
        double res = 1;
        for(int i = 1; i<=r; i++){
            res = res* (N-r+i)/i;
        }
        return (int)res;
        
    }
}
Time Complexity O(n-1) or O(m-1)
Constant space


But here one solution is missing that is reccursion, so when youy
will go in the interview try to tell the recursion first.

