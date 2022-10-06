class Solution {
    
    // Time Complexity = O(n2);
    // Space Complexity = O(n2);
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        al.add(1);
        res.add(al);
        
        
        for(int j = 1 ; j<numRows; j++){
            List<Integer>prev = res.get(j-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int i =1; i<prev.size() ; i++){
                int previous = prev.get(i-1);
                int curr = prev.get(i);
                int sum = previous + curr;
                row.add(sum);
            }
            row.add(1);
            res.add(row);
        }
        
        
        
        return res;
    }
}