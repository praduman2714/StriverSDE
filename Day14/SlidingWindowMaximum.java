Think of the brute force by youself, it is easy 
Time Complexity : O(N2)


The optimal approach :
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int j = 0;
        for(int i = 0; i< n; i++){
            while(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k-1){
                res[j++] = nums[dq.peek()];
            }
            
        }
        return res;
    }
}

Time Complexity : O(N)
Space Complexity : O(N)