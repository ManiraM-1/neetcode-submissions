class MedianFinder {
    PriorityQueue<Integer>maxHeap;
    PriorityQueue<Integer>minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        double ans = 0;
        if(maxHeap.size()==minHeap.size()){
            ans = (double) (maxHeap.peek()+minHeap.peek()) /2.0;
        }else{
            ans = (double)maxHeap.peek();
        }
        return ans;
    }
}
