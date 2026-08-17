class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer>map = new HashMap<>();
        for(char c: tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(map.values());
        int maxFreq = pq.peek();
        int maxCount = 0;
        for(char  c: map.keySet()){
            if(map.get(c)==maxFreq){
                maxCount++;
            }
        }
        int ans = (maxFreq-1)*(n+1)+maxCount;
        return Math.max(ans,tasks.length);
    }
}
