class KthLargest {
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
