class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length -1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1) mid++;
            else{
                if(nums[mid] == 2){
                    swap(nums, mid, high);
                    //mid++;
                    high--;
                }
            }
        }
    }
    
    public void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}

// Another Approach

class Solution {
    // Time Complexity : o(n) + o(n);
    public void sortColors(int[] nums) {
        int one = 0, two = 0, zero = 0;
        for(int val : nums){
            if(val == 0) zero++;
            else if(val == 1) one++;
            else  two++;
        }
        int j = 0;
        for(int i = 0; i<zero ; i++){
            nums[i+j] = 0;
        }
        for(int i = zero; i<one+zero; i++){
            nums[i] = 1;
        }
        for(int i = one+zero; i<nums.length; i++){
            nums[i] = 2;
        }
        
    }
}
