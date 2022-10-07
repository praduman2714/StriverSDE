Time complexity o(n)
Space Complexityo(n)
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int val : nums){
            if(hs.contains(val))
                return val;
            else hs.add(val);
        }
        
        return -1;
    }
}

// For more approach follow the LC#287
