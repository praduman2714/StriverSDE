class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Time Complexity = o(n^2);
        // Constant space
        int n = matrix.length; 
        int m = matrix[0].length; 
        
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}

Another approach

class Solution {

Time Complexity = o(n*m)
Space Complexity = o(n*m)
This approach you just have to say to interviewer do not code it.
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[n*m];
        
        int k = 0;
        for(int[] val : matrix){
            for(int v : val){
                arr[k++] = v;
            }
        }
        
        
        int i = 0, j = n*m-1;
        
        while(i <= j){
            int mid = (i + j)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                j = mid - 1;
            }else{
                i = mid+1;
            }
        }
        return false;
    }
}

The Best Approach 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Time Complexity = o(log (n*m));
        // Space Complexity = o(1);
        int n = matrix.length;
        int m = matrix[0].length;
        
        int i = 0, j = m-1;
        while(i < n && j >=0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        
        return false;
    }
}