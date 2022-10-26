Comon man you know the brute force, it will take Time O(N*N) and space as O(1)

import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            st.push(i);
        }
        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();
            if(Runner.knows(a, b)== true){
                st.push(b);
            }else 
                st.push(a);        
        }
        int celeb = st.pop();
        for(int i = 0; i<n; i++){
            if(i == celeb) continue;
            if(!Runner.knows(i, celeb) || Runner.knows(celeb, i)){
                return -1;
            }
        }
        return celeb;
    }
}

Time complexity : O(N)
Space complexity : O(N)