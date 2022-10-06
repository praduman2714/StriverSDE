class Solution {
    
    // Space Complexity : O(1);
    // Time Complexity : O(mn);
    
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        for(int i = 0 ; i<matrix.length; i++){
            if(matrix[i][0] == 0) isCol = true;
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int i = 0;i<matrix[0].length ; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(isCol){
            for(int i = 0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}


2nd approach

class Solution {
    
    // Space Complexity : O(m) + O(n);
    // Time Complexity : O(mn);
    
    public void setZeroes(int[][] matrix) {
        Set<Integer> row =new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(row.contains(i) || col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
       // return matrix;
    }
}