class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j)-> map.get(i)- map.get(j));
        for(int val : map.keySet()){
            pq.add(val);
            if(pq.size() > k) pq.poll();
        }
        
        for(int i = 0; i<k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}

Time Complexity : O(N log N)
Space Complexity : O(N)

The optimal Approach

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : nums) map.put(val , map.getOrDefault(val, 0) + 1);
        
        List<Integer> busket[] = new ArrayList[nums.length + 1];
        for(int val : map.keySet()){
            int freq = map.get(val);
            if(busket[freq] == null){
                busket[freq] = new ArrayList<>();
            }
            busket[freq].add(val);
        }
        
        int idx =0;
        int[] res = new int[k];
        for(int i = busket.length-1 ; i>= 0 ; i--){
            if(busket[i] != null){
                for(int val : busket[i]){
                    res[idx++] =val;
                    if(idx == k) return res;
                }
                
            }
        }
        return res;
    }
}

Time Complexity : O(N) 
