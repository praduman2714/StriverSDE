class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (j-i));
        for(int val : nums) pq.add(val);
        
        int i = 1;
        while(i < k){
            pq.poll();
            i++;
        }
        return pq.peek();
        
    }
}


This is just the one approach
The next approach would be that we would have used the Arrays.sort method and then we would
simply returned the particular element. That would take the Time Complexity O(NlogN) and
constant space complexity.

The above mehtod uses O(N) time and O(N) space complexity.
