class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        int ind  =0;
        while(ind < s.length() && s.charAt(ind) == ' '){
            ind++;
        }
        
        boolean plus = true;
        
        if(ind < s.length()){
            if(s.charAt(ind) == '-'){
                plus = false;
                ind++;
            }else if(s.charAt(ind) == '+'){
                ind++;
            }
        }
        int res = 0;
        while(ind < s.length() && Character.isDigit(s.charAt(ind))){
            int dig = s.charAt(ind)-'0';
            
            if (res > (Integer.MAX_VALUE / 10) || (res == (Integer.MAX_VALUE / 10) && dig > 7)){
                 return !plus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
             }
            
            res = (res*10)+dig;
            ind++;
        }
        
        return plus ? res : -1*res;
    }
}
Time complexity ; O(n)
constant space