import java.util.* ;
import java.io.*; 
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int len = 0;
        int sum  = 0;
        for(int i = 0; i<arr.size() ; i++){
            sum+=arr.get(i);
            if(sum == 0){
                maxLen = i+1;
            }else{
                if(map.containsKey(sum)){
                    maxLen = Math.max(maxLen, i-map.get(sum));
                }else{
                    map.put(sum, i);
                }
            }
        }
        return maxLen;
	}
}
Time complxity and space complexity : O(N)