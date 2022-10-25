The first thing first is that we have to give the brute force approach to the interviewer.
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
            
        smallestelementleft(heights, left);
        smallestelementright(heights, right);
        System.out.println(Arrays.toString(right));
        int max  = 0;
        for(int i = 0; i<n; i++){
            int widht = Math.abs(left[i] - right[i]) + 1;
            int area = widht * heights[i];
            max =Math.max(max, area);
        }
        return max;
        
    }
    
    public void smallestelementleft(int[] arr, int[] left){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            left[i]= (st.isEmpty())? 0:st.peek()+1;
            st.push(i);
        }
    }
    
    public void smallestelementright(int[] arr, int[] right){
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length - 1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            right[i] = (st.isEmpty()) ? arr.length - 1 : st.peek()-1;
            st.push(i);
        }
    }
}

Time complexity : O(N)
Space complexity : O(N) we have used 3 N size data structure


Other optimized approach
for better understanding follow takeYou forwared 
We can observe that the stack is filled in the linear increasing order.

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max =0;
        int n = heights.length;
        for(int i = 0; i<=n; i++){
            while(!st.isEmpty() && (i== n || heights[st.peek()] >= heights[i])){
                int len = heights[st.peek()];
                st.pop();
                int wid = (st.isEmpty()) ? i : i- st.peek() - 1;
                int area = len * wid;
                max = Math.max(max, area);
            }
            st.push(i);
        }
        
        return max;
    }
}

Time complexity : O(N)
Space compexit : O(N)
It is one pass solutions
