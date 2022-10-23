class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((i, j) -> (j-i));
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() < maxHeap.size()){
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek())/2.0d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

Dry run this question you will get the idea.
Time complexity : O(log n)
Space Complexity : O(n)

