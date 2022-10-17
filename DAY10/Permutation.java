class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }
    
    public void helper(int[] nums, int st, List<List<Integer>> res){
        if(st == nums.length){
            List<Integer> al = new ArrayList<>();
            for(int val : nums){
                al.add(val);
            }
            res.add(new ArrayList<>(al));
            return;
        }
        
        for (int i = st; i < nums.length; i++) {
            swap(i, st, nums);
            helper( nums, st+1 ,res);
            swap(i, st, nums);
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

Time complexity : O(N! * N);
Space Complexity : O(1)
