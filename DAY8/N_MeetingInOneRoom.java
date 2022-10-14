class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int[][] pair = new int[n][2];
        for(int i = 0; i<n; i++){
            pair[i][0] = start[i];
            pair[i][1] = end[i];
        }
        
        Arrays.sort(pair, (x, y) -> (x[1] - y[1]));
        
        int c = 1;
        int prev = pair[0][1];
        for(int i = 1; i<n; i++){
            if(pair[i][0] > prev){
                c++;
                prev = pair[i][1];
            }
        }
        
        return c;
        
    }
}

Time Complexity : O(n log n)
Space Complexity : O(n) because we used extra space to store the endTime and Start time.