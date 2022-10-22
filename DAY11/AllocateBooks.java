public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(B > A.size()) return -1;
        int low = 0;
        int high= 0;
        for(int val : A){
            low = Math.min(low, val);
            high+= val;
        }
        int ans = -1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(isPossible(A, B, mid)){
                high= mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(ArrayList<Integer> al , int B, int atPar){
        int sum = 0, c = 0;
        for(int val : al){
            //sum+= val;
            if(sum + val > atPar){
                c++;
                sum = val;
                if(sum > atPar) return false;
            }else{
                sum+=val;
            }
        }
        if(c < B) return true;
        return false;
    }
}

Time complexity : O(NlogN)
Space complexity : O(1)