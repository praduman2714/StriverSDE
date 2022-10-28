The question is form CodeStudio
Take the link form striver sde day 16 questio 1

The question can also be made using inbuilt fuction in java

public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        int c = 0;
        while(s.indexOf(p) != -1){
            c++;
            int val = s.indexOf(p);
            s = s.substring(val+1);
        }
        
        return c;
	}

}

The Z-algorithm method

public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        String cc = p+"#"+s;
        int len = cc.length();
        int[] z = ZAlgo(cc);
        int c = 0;
        for(int val : z){
            if(val == m) c++;
        }
        return c;
	}
    
    public static int[] ZAlgo(String st){
        int left = 0, right = 0;
        int [] arr = new int[st.length()];
        
        for(int k = 0; k<arr.length; k++){
            
            if(k > right){
                left = k;
                right = k;
                
                while(right < arr.length && st.charAt(right) == st.charAt(right - left)){
                    right++;
                }
                arr[k] = right - left;
                right--;
            }else{
                int k1 = k - left;
                if(arr[k1] < right - k + 1){
                    arr[k] = arr[k1];
                }else{
                    left = k;
                    while(right < arr.length && st.charAt(right) == st.charAt(right - left)){
                        right++;
                    }
                    arr[k] = right - left;
                    right--;
                }
            }
        }
        return arr;
    }

}
TIme complexity : O(N+M)