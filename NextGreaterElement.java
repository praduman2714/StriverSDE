Using double array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] doubles = new int[2*nums.length];
        int ii = 0;
        for(int val : nums){
            doubles[ii++] = val;
        }
        for(int val :nums){
            doubles[ii++] = val;
        }
        int[] res  = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int val = nums[i];
            boolean flag = false;
            for(int j = i+1 ; j<doubles.length; j++){
                if(doubles[j] > val){
                    res[i] = doubles[j];
                    flag = true;
                    break;
                }
            }
            if(!flag) res[i] = -1;
        }
        return res;
    }
}

Time Complexity : O(N^2)
Space Complexity : O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res  = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int val = nums[i];
            res[i]= -1;
            for(int j = 1 ; j<nums.length; j++){
                if(nums[(i + j)% n] > val){
                    res[i] = nums[(i+j)% n];
                    //flag = true;
                    break;
                }
            }
            
        }
        return res;
    }
}

Time Complexity : O(N^2)
Space Complexity : O(N)


Optimal approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 2*n - 1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i%n]){
                st.pop();
            }
            res[i%n] = st.isEmpty() ? -1 : nums[st.peek()];
            st.push(i%n);
        }
        return res;
        
    }
    
}

Time complexity : O(N)
Space complexity : O(N)