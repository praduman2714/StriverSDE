class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0, i = 0, j= 0;
        int max = -1;
        while(j < nums.length){
            if(nums[j] == 1){
                j++;
            }else{
                int len = j - i;
                max= Math.max(max, len);
                j++;
                i = j;
            }
        }
        int len = j-i;
        max = Math.max(max, len);
        return max;
    }
}

It is the only approach 
Time Complexity O(N)
constast space.