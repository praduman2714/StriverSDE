class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public  boolean solve(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {

          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;

              if (solve(board))
                return true;
              else
                board[i][j] = '.';
            }
          }

          return false;
        }
      }
    }
    return true;
  }
    
    
    public boolean isValid(char[][] board , int row, int col, char ch){
        for(int i = 0; i<9; i++){
            if(board[i][col] == ch) return false;
            if(board[row][i] == ch) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
                return false;
        }
        return true;
    }
}

Time Complexity : O(9^(n^2))
Space Complexity : O(1)