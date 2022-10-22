The first approach which you will be telling the interviewer is using a additional data structure 
that will be map, and the element which frequenccy is one, return that number.
It will take Time complexity : O(N) and space as O(N)

The second approach is that in which you we will take the xor of all the nynber and will return the 
xor of the array.
O(N) and will take space complexity as O(1)



Optimal approach
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi =nums.length-2;
        
        while(lo <= hi){
            int mid = (lo + hi)>>1;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }else{
                if(nums[mid] == nums[mid+1]){
                    hi = mid -1;
                }else{
                    lo = mid+1;
                }
            }
        }
        return nums[lo];
    }
}

Time complexity : O(log N)
Space complexity : O(1)