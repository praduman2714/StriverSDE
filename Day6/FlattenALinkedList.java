/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    Node temp = root;
	    while(temp != null){
	        Node bot = temp;
	        while(bot != null){
	            pq.add(bot.data);
	            bot = bot.bottom;
	        }
	        temp = temp.next;
	    }
	    
	    Node res = new Node(-1);
	    temp = res;
	    while(!pq.isEmpty()){
	        int val = pq.poll();
	        Node val1 = new Node(val);

	        temp.bottom = val1;
	        temp = temp.bottom;
	        
	    }
	    temp.bottom = null;
	    
	    return res.bottom;
    }
}

Not a optimal solutions, as it take extra space

Optimal Approach
It uses constant space
/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    Node temp = root;
	    while(temp != null){
	        Node bot = temp;
	        while(bot != null){
	            pq.add(bot.data);
	            bot = bot.bottom;
	        }
	        temp = temp.next;
	    }
	    
	    Node res = new Node(-1);
	    temp = res;
	    while(!pq.isEmpty()){
	        int val = pq.poll();
	        Node val1 = new Node(val);

	        temp.bottom = val1;
	        temp = temp.bottom;
	        
	    }
	    temp.bottom = null;
	    
	    return res.bottom;
    }
}