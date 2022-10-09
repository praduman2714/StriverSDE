The first approach is brute force in which we take signal number and iterate
over it and check is num+1 is present in the array of not.
The time complexity is O(n3) with a constant space.

The next Approach is 
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) pq.add(val);
        
        int maxLen = Integer.MIN_VALUE;
        int len = 1;
        int val = pq.poll();
        while(pq.size() != 0){
            //System.out.println(val);
            if(pq.peek() == val+1){
                len++;
                maxLen = Math.max(maxLen, len);
            }else if(pq.peek() == val){
                maxLen = Math.max(maxLen, len);
            }
            else{
               // maxLen = Math.max(maxLen, len);
                len= 1;
            }
            val = pq.poll();
        }
        return maxLen;
    }
}

Time complexity = O(n) + O(log n)
Space Complexity = O(n)

The optimal Approach
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int val : nums) hs.add(val);
        int len = 1;
        int maxLen = 0;
        
        for(int val : nums){
            if(!hs.contains(val - 1)){
                int curr = val;
                len = 1;
                while(hs.contains(curr + 1)){
                    len++;
                    curr++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
        
    }
}

Time complexity == Space Complexity : O(N) 
Although the time comlexity looks like O(n2) but it linear for more 
refrence follow Leetcode Problem No 128.