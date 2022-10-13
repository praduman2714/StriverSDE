/** The Brute force approach would be that we have to take out the water stored at each position
 for this we have to compute leftMax and RightMax for each position. 
Time Complexity : O(N2) 
Space Complexity : O(1)


The another approach that takes Time Complexity of O(N) but takes the space as O(N)
In this method we would store the leftMax and rightMax at the particular index with the help 
of a prefix and suffix array, and then compute the rest.

*/
The optimal Approach:
class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while(i <= j){
            if(height[i] <= height[j]){
                if(leftMax < height[i]){
                    leftMax = height[i];
                }else{
                    res+= leftMax - height[i];
                }
                i++;
            }else{
                if(rightMax < height[j]){
                    rightMax = height[j];
                }else{
                    res+= rightMax - height[j];
                }
                j--;
            }
        }
        return res;
    }
}
TIme complexity :O(N)
Space Complexity : O(1)

In interview explain the above, because the stack method is bit more complected to explain
