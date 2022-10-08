The first approach which come to mind is the brute force approach
that will take quadratic timeO(n2).

The optimal approach is using merge sort, we just have to modify
the merge sort technique
For more refrence see the post : https://takeuforward.org/data-structure/count-reverse-pairs/

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public int mergeSort(int[] nums, int low, int high){
        if(low >= high) return 0;
        int mid = (low + high)/2;
        int inv = 0;
        inv += mergeSort(nums, low, mid);
        inv+= mergeSort(nums, mid+1, high);
        inv+= merge(nums, low, mid, high);
        return inv;
    }
    
    public int merge(int[] nums, int low, int mid, int high){
        int c = 0;
        int j = mid+1;
        for(int i = low; i<= mid ; i++){
            while(j <= high && nums[i] > (2*(long)nums[j])){
                j++;
            }
            c += (j - (mid+1));
        }
        int left = low, right = mid+1;
        ArrayList<Integer> al = new ArrayList<>();
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                al.add(nums[left++]);
            }else{
                al.add(nums[right++]);
            }
            
        }
        
        while(left <= mid){
            al.add(nums[left++]);
        }
        while(right <= high){
            al.add(nums[right++]);
        }
        
        for(int i =low; i<= high; i++){
            nums[i] = al.get(i-low);
        }
        
        return c;
        
        
        
    }
}