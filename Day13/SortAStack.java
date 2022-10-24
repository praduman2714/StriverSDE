import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> st) {
		// Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        helper(st, pq);
        helper1(pq, st);
	}
    
    public static void helper1(PriorityQueue<Integer> pq, Stack<Integer> st ){
        while(pq.isEmpty()) return ;
        st.push(pq.poll());
        helper1(pq, st);
    }
    
    
    public static void helper(Stack<Integer> st , PriorityQueue<Integer> pq){
        while(st.isEmpty()) return ;
        pq.offer(st.pop());
        helper(st, pq);
    }

}
This same approach can be done using loop, 
Time Complexity : O(N)
Space Complexity : O(N)

Another approach space optimized 
import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> st) {
		// Write your code here.
        if(st.isEmpty()) return ;
        int top = st.pop();
        sortStack(st);
        insertSorted(st, top);
        
	}
    
    public static void insertSorted(Stack<Integer> st, int top){
        if(st.isEmpty() || st.peek() < top){
            st.push(top);
            return ;
        }
        int peek = st.pop();
        insertSorted(st, top);
        st.push(peek);
        
        
    }

}