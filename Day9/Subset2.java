class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        helper(0, nums,  new ArrayList<>() , res);
        return res;
    }
    
    public void helper(int ind, int[] nums,  List<Integer> ds , List<List<Integer>>res){
        res.add(new ArrayList<>(ds));
        for(int i = ind; i < nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]){
                continue;
            }
            
            ds.add(nums[i]);
            helper(i+1, nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}

Time Complexity : o(2^n)
Space Complexity : O(n)
Reffer striver SDE sheet for more.