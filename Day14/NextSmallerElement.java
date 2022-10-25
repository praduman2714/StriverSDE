public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] arr = new int[A.size()];
        int n = A.size();
        for(int i = n-1; i>=0 ; i--){
            arr[i] = -1;
            for(int j = i-1 ; j>=0; j--){
                if(A.get(j) < A.get(i)){
                    arr[i] = A.get(j);
                    break;
                    
                }
            }
        }
        for(int val : arr) al.add(val);
        return al;
    }
}

//Time Complexity : O(N^2)
//Space complexity : O(N)

Optimal approach

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] arr = new int[A.size()];
        Stack<Integer> st = new Stack<>();
        int n = A.size();
        for(int i = 0; i<n ; i++){
            while(!st.isEmpty() && st.peek() >= A.get(i)){
                st.pop();
            }
            arr[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(A.get(i));
            
        }
        for(int val : arr) al.add(val);
        return al;
    }
}

//Time complexity : O(N)
//Space complexity : O(N)