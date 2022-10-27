The brute force approach:
for (int i = 0; i < str.length(); i++) {
        for (int j = i; j < str.length(); j++) {
            int flag = 1;
 
            // Check palindrome
            for (int k = 0; k < (j - i + 1) / 2; k++)
                if (str.charAt(i + k) != str.charAt(j - k))
                    flag = 0;
 
            // Palindrome
            if (flag!=0 && (j - i + 1) > maxLength) {
                start = i;
                maxLength = j - i + 1;
            }
        }
    }

Time complexity : O(N^3)
Space complexity : O(1)

Another approach : Using dp

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res= null;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
              dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

              if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                res = s.substring(i, j + 1);
              }
            }
          }
        return res;
    }
}

Time complexity : O(N2)
space complexity : O(N2)

The optimal approach
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int n = s.length();
        int st = 0, end = 0;
        for(int i = 0 ;i<n ; i++){
            int len1 = expandArong(s, i, i);
            int len2 = expandArong(s, i , i+1);
            
            int len = Math.max(len1, len2);
            if(len > end - st){
                st = i - (len - 1)/2;
                end = i+ (len)/2;
            }
        }
        return s.substring(st, end+1);
    }
    
    public int expandArong(String s, int i, int j){
        int l =i, r = j;
        while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--; r++;
        }
        return r-l-1;
    }
}

Time complexity : O(N2)
Space complexity : O(1)

