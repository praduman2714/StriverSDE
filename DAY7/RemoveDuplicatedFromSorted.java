The Brute force approach will be it's taking a extra Data Structure.
 The optimal solutions

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int i = 0, j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                nums[k++] = nums[j];
                i =j;
                j++;
            }
        }
        return k;
    }
}

Time Complexity O(n)
constant space;