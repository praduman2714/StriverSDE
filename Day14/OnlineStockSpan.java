class StockSpanner {
    class Pair{
        int x , y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    Stack<Pair> st =new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int c = 1;
        while(!st.isEmpty() && st.peek().x <= price){
            c+= st.peek().y;
            st.pop();
        }
        st.push(new Pair(price, c));
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

Time complexity : O(1) 
Even though there is a while loop in next, that while loop can only run nn times total across the entire algorithm. 
Each element can only be popped off the stack once, and there are up to nn elements.

This is called amortized analysis - if you average out the time it takes for next to run across nn calls,
it works out to be O(1)O(1). If one call to next takes a long time because the while loop runs many times,
then the other calls to next won't take as long because their while loops can't run as long.

Space Complexity : O(N)