//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> al = new ArrayList<>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
       // al.add(0);
        helper(0,0, arr, N);
        return al;
    }
    
    public void helper(int i ,int sum ,  ArrayList<Integer> arr, int n){
        if(i == n){
            al.add(sum);
            return;
        }
        
        helper(i+1, sum+arr.get(i) , arr, n);
        helper(i+ 1, sum, arr, n);
    }
}

Time Complexity = O(2^N log(2^N)).
Space Complexity = O(2^N)