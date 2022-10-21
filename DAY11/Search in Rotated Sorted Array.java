class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0; i<nums.length ; i++){
            if(nums[i] == target) return i;
        }
        return -1;
    }
}

Time complexity ; O(N)
Space complexity : O(1)

Optimal approach 

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high= nums.length - 1;
        while(high - low > 1){
            int mid = (high + low) >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[low]){
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid-1;
                }else{
                    low = mid +1;
                }
            }else{
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        if(nums[low] == target) return low;
        if(nums[high] == target) return high;
        return -1;
    }
}

Time Complexity : O(log n)
Space Complexity : O(1)

This done with the help of binary seach,
their is one more solution in LC # 33 it's first solution it is also O(N) solutions
