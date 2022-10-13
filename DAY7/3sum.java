The Brute Force approach is of time complexity O(N3) , and space complexity of O(3k);

The optimal approach is 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n < 3) return res;
        
        for(int i = 0 ; i<n-2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int l = i+1, r = n-1;
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0){
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[l]);
                        al.add(nums[r]);
                        res.add(al);
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;r--;
                    }else if(sum > 0){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
Time complexity is O(N2)
Space comlextity is the O(3k)
