import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ArrayList<Integer> al : kArrays){
            for(int val : al){
                pq.add(val);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(pq.size() > 0){
            res.add(pq.poll());
        }
        return res;
	}
}
Time Complexity : O(N*K)
Space Complexity : O(N*K)