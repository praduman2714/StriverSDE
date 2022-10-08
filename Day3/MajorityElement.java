Go though this link for more method.
https://leetcode.com/problems/majority-element/

This is just one method, explore the solution section of LC#169


class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map =new HashMap<>();
        int c = 0;
        for(int val : nums){
            map.put(val , map.getOrDefault(val, 0) + 1);
            c++;
        }
        
        for(Map.Entry<Integer, Integer> entry  : map.entrySet()){
            int val = entry.getValue();
            if(val > c/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}

Time Complexity : O(n)
Space Complexity : O(n)