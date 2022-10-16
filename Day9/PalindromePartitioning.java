class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(0, s, res, new ArrayList<>());
        return res;
    }
    
    public void helper(int s, String st, List<List<String>> res, List<String> al){
        if(s >= st.length()){
            res.add(new ArrayList<>(al));
            return;
        }
        
        for(int i = s; i<st.length(); i++){
            if(isValid(st, s, i)){
                al.add(st.substring(s, i+1));
                helper(i+1, st, res, al);
                al.remove(al.size() - 1);
            }
            
        }
    }
    
    public boolean isValid(String st, int l, int r){
        while(l < r){
            char ch = st.charAt(l);
            char ch1 = st.charAt(r);
            if(ch == ch1){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
Time Complexity: O( (2^n) *k*(n/2) )

Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome. O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.

Space Complexity: O(k * x)

Reason: The space complexity can vary depending upon the length of the answer. k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).