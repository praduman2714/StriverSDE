class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, res, new ArrayList<>());
        return res;
    }
    
    public void helper(int st, int[] cand, int target, List<List<Integer>> res, List<Integer> al){
        if(target < 0) return ;
        if(target == 0){
            res.add(new ArrayList<>(al));
        }
        
        for(int i=st; i<cand.length; i++){
            al.add(cand[i]);
            helper(i, cand, target - cand[i] , res, al);
            al.remove(al.size() - 1);
        }
    }
}

Time Complexity : O(2^n)
Space Complexity : 