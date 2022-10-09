class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Time Complexity O(n2);
        // Constant space;
        int[] res = new int[2];
        for(int i =0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                     break ;
                }
            }
        }
        
        return res;
    }
}

Another Approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Time Complexity : O(n log n)
        // Space Complexity : O(n);
        int[] store = new int [nums.length];
        for(int i = 0; i<nums.length; i++){
            store[i] = nums[i];   
        }
        
        
        int[] res = new int[2];
        Arrays.fill(res, -1);
        Arrays.sort(store);
        int ii = 0;
        int j = nums.length-1;
        int n1 = 0, n2 = 0;
        
        while(ii < j){
            //System.out.println(nums[ii] + " " + nums[j]);
            int sum = store[ii] + store[j];
           // System.out.println(sum);
            if(sum == target){
                n1 = store[ii];
                n2 = store[j];
                break;
            }else if(sum > target){
                j--;
            }else{
                ii++;
            }
        }
        //System.out.println(n1 + "  " + n2);
        for(int  i = 0; i<nums.length; i++){
            if(n1 == nums[i] && res[0] == -1) res[0] = i;
            else if(n2 == nums[i] && res[1] == -1) res[1] = i;
        }
        return res;
    }
}

Optimal Approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int tar = target - nums[i];
            if(map.containsKey(tar)){
                res[0] = i;
                res[1] = map.get(tar);
                //return res;
            }else
                map.put(nums[i] , i);
        }
        return res;
    }
}

Time complexity : O(n)
Space Complexity : o(n)