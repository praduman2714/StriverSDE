class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res  = new ArrayList<>();
        char ch[][] = new char[n][n];
        for(char[] c : ch){
            Arrays.fill(c, '.');
        }
        int[] left = new int[n];
        int[] rightD = new int[(2*n)-1];
        int[] leftD = new int[(2*n)-1];
        
        dfs(ch, 0, res, left, rightD, leftD);
        return res;
    }
    
    public void dfs(char [][] board , int col, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
        if(col == board.length){
            res.add(construct(board));
            return ;
        }
        //int n = ch.length;
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                dfs(board, col + 1, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
    
    public List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    
}

Time Complexity :O(N! * N)
Space Complexity : O(N)

Less optimal approach


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res  = new ArrayList<>();
        char ch[][] = new char[n][n];
        for(char[] c : ch){
            Arrays.fill(c, '.');
        }
        
        dfs(ch, 0, res);
        return res;
    }
    
    public void dfs(char [][] ch , int col, List<List<String>> res){
        if(col == ch.length){
            res.add(construct(ch));
            return ;
        }
        
        for(int i = 0; i<ch.length; i++){
            if(validate(ch, i, col)){
                ch[i][col] = 'Q';
                dfs(ch, col+1, res);
                ch[i][col] = '.';
            }
        }
    }
    
    public List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
}

Time complexity : O(n!*n)
