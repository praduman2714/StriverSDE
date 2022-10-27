class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for(int i = 1; i<strs.length; i++){
            String st = strs[i];
            String temp = "";
            int j = 0;
            while(j < st.length() && j < res.length()){
                if(res.charAt(j) == st.charAt(j)){
                    temp += res.charAt(j);
                }else{
                    break;
                }
                j++;
            }
            res = temp;
        }
        return res;
    }
}
Time complexity : O(N*N)
constant space complexity

Divide and conqure method

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        return longestPrefix(strs, 0, strs.length-1);
    }
    
    public String longestPrefix(String[] strs, int l, int r){
        if(l == r) return strs[l];
        else{
            int mid = (l + r)>>1;
            String left = longestPrefix(strs, l, mid);
            String right = longestPrefix(strs, mid+1, r);
            return common(left, right);
        }
    }
    
    public String common(String left, String right){
        int min = Math.min(left.length() , right.length());
        for(int i = 0; i<min; i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}

