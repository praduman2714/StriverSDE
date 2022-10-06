So for the interview we have to first say the the brute force
approach to the interviewer.

For more reffer to TakeYouForward

class Solution {
    // Space Complexity = O(1)
    // Time Complexity = o(n)
    // Reffer to TakeYouForward for more solutions.
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return nums[0];
        int sum=0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while(j < nums.length){
            sum+= nums[j];
            maxSum = Math.max(maxSum , sum);
            if(sum <= 0){
                sum = 0;
                i = j;
            }
            j++;
        }
        return maxSum;
    }
}

// Another Approach
class Solution {
    // Divide and Conqure
    public int maxSubArray(int[] nums) {
        return findMax(nums, 0, nums.length-1);
    }
    
    public int findMax(int [] arr, int st, int end){
        if(st == end) return arr[st];
        
        int mid = (st + end)/2;
        int left = findMax(arr, st, mid);
        int right = findMax(arr, mid+1, end);
        int corringSum = findCrossing(arr, st, mid, end);
        return Math.max(left, Math.max(right, corringSum));
    }
    
    public int findCrossing(int[] arr , int st, int mid, int end){
        int left = 0;
        int leftMax = Integer.MIN_VALUE;
        int right = 0, rightMax = Integer.MIN_VALUE;
        for(int i = mid; i>=st; i--){
            left+=arr[i];
            leftMax = Math.max(leftMax, left);
        }
        for(int i = mid+1 ; i<=end; i++){
            right+=arr[i];
            rightMax = Math.max(rightMax, right);
        }
        return leftMax + rightMax;
    }
}