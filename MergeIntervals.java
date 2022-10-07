class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));
        List<int[]> al  = new ArrayList<>();
        for(int[] val : intervals){
            if(al.isEmpty() || al.get(al.size() - 1)[1] < val[0]){
                al.add(val);
            }else{
                al.get(al.size() - 1)[1] = Math.max(val[1] , al.get(al.size() - 1)[1]);
            }
        }
        
        int[][] res = new int[al.size()][2];
        int i = 0;
        for(int[] val : al){
            res[i][0] = val[0];
            res[i][1] = val[1];
            i++;
        }
        return res;
    }
}

// Another approach

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[] > al = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] val : intervals){
            if(val[0]  <= end){
                end = Math.max(val[1], end);
            }else{
                al.add(new int[] {start ,end});
                start = val[0];
                end = val[1];
            }    
        }
        
        al.add(new int[] {start, end});
        return al.toArray(new int[0][]);
    }
}

Time complexity = O(n log n)
Space complexty = O(n);
