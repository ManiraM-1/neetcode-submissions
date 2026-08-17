class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((x,y)->map.get(x)-map.get(y));
        for(int i: map.keySet()){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        int ans[] = new int[k];
        int x=0;
        while(!pq.isEmpty()){
            ans[x++]=pq.poll();
        }
        return ans;
    }
}
