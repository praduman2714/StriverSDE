class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().replaceAll("\\s+", " ").split(" ");
        int i = 0, j = arr.length - 1;
        while(i < j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        
        String str = "";
        for(String st : arr){
            str+=st + " ";
        }
        return str.trim();
        
    }
}

Time Complexity : O(N)
Space Complexity : O(N)


Another Approach

THis is the space optimized approach

class Solution {
    public String reverseWords(String s) {
        int i = 0;
        String res= "";
        String temp = "";
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch != ' '){
                temp+=ch;
            }else{
                if(!temp.equals("")){
                    res = temp + " " + res;
                }
                temp = "";
            }
            i++;
        }
        
        if(!temp.equals("")){
            res = temp + " " + res;
        }
        
      
        return res.trim();
    }
}
