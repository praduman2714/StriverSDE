import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        Collections.sort(arr);
        int andd = 0;
        for(int i = 1; i<n; i++){
            if(arr.get(i) == arr.get(i-1)){
                andd = arr.get(i);
                break;
            }
        }
        
        int tsum = (n*(n+1))/2;
        int sum = 0;
        for(int val : arr){
            sum+=val;
        }
        sum-= andd;
        int missing = tsum - sum;
        int[] res = new int[2];
        res[0] = missing;
        res[1] = andd;
        return res;
    }
}
// Time complexity : O(n log n)
// Space Complexity : O(1)

Another approach
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        Set<Integer> hs =new HashSet<>();
        int andd = 0;
        for(int val : arr){
            if(hs.contains(val)){
                andd = val;
                break;
            }
            hs.add(val);
        }
        
        int tsum = (n*(n+1))/2;
        int sum = 0;
        for(int val : arr){
            sum+=val;
        }
        sum-= andd;
        int missing = tsum - sum;
        int[] res = new int[2];
        res[0] = missing;
        res[1] = andd;
        return res;
    }
}

This can be found in code studio
