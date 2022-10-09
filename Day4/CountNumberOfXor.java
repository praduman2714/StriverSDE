The first approach is brute force that will take O(n2) of time
and constant space.

This is optimal solution
O(N) time complexity and O(N) space complexity

import java.util.* ;
import java.io.*; 
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int xor = 0;
        //System.out.println(0 ^ 8);
        int c = 0;
        for(int i = 0; i<arr.size() ; i++){
            xor = xor^arr.get(i);
            if(map.containsKey(xor^x)){
                c+= map.get(xor^x);
            }cmd
            map.put(xor , map.getOrDefault(xor, 0) + 1);
        }
        
        return c;
	}
}