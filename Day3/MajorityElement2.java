This is brute force method, with constant space.

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> al  = new ArrayList<>();
        for(int val : nums){
            int count = 0;
            for(int ele : nums){
                if(val == ele){
                    count++;
                }
            }
            if(count > nums.length / 3 && !al.contains(val)) al.add(val);
        }
        return al;
    }
}


Another approach..
class Solution {
    public List<Integer> majorityElement(int[] nums) {
	// Time Complexity : O(n)
	// Space Complexity : o(n)
        List<Integer> al = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int limit = nums.length / 3;
        for(int val : map.keySet()){
            if(map.get(val) > limit){
                al.add(val);
            }
        }
        return al;
    }
}

Optimal Solution with Time complexityO(n) and constant space
class Solution {
    public List<Integer> majorityElement(int[] nums) {
            int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
            for (int i = 0; i < len; i++) {
              if (nums[i] == number1)
                count1++;
              else if (nums[i] == number2)
                count2++;
              else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
              } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
              } else {
                count1--;
                count2--;
              }
            }
            ArrayList < Integer > ans = new ArrayList < Integer > ();
            count1 = 0;
            count2 = 0;
            for (int i = 0; i < len; i++) {
              if (nums[i] == number1)
                count1++;
              else if (nums[i] == number2)
                count2++;
            }
            if (count1 > len / 3)
              ans.add(number1);
            if (count2 > len / 3)
              ans.add(number2);
            return ans;

    }
}