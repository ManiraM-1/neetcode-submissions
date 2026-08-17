class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int i: map.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[] = new int[k];
        int x=0;
        while(!pq.isEmpty()){
            ans[x++]=pq.poll();
        }
        return ans;
    }
}
